package com.zygo.mvc.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zygo.mvc.Repository.UserRepository;
import com.zygo.mvc.Service.LegsService;
import com.zygo.mvc.entities.LegsExercice;
import com.zygo.mvc.entities.LegsSerie;
@Controller
public class LegsController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private LegsService service;
	@GetMapping("/ProgrammeLegs/{username}")
	public String pectoralsindex(Model model,@PathVariable String username) {
		model.addAttribute("exercice", this.service.getAllExoByUsername(username));
		return "LegsProgramme";
	}
	@GetMapping("/addELe/{username}")
	public String add(Model model, Model model2, @PathVariable String username) {
		model2.addAttribute("username", userRepo.findByUsername(username));
		model.addAttribute("exercice", new LegsExercice());
		return "addExoLe";
	}
	@PostMapping("/addELe/{username}")
	public String store(@ModelAttribute LegsExercice e, Model model, @PathVariable String username) {
		model.addAttribute("username", userRepo.findByUsername(username));
		this.service.saveExercice(e, username);
		return "redirect:/ProgrammeLegs/{username}";
	}
	@GetMapping("/ProgrammeLegs/exercice/{id}")
	public String series(Model model2,Model model,Model model3, @PathVariable Long id ) {
		model.addAttribute("exercice", service.findByIdEL(id));
		LegsExercice e = service.findByIdEL(id);
		model.addAttribute("allSerie", service.getAllSerieByEx(e));
		model2.addAttribute("serie", new LegsSerie());
		Map<Integer, Double> surveyMap = new LinkedHashMap<>();
		int cpt=0;
		for(LegsSerie absserie : e.getSeriesLe() ) {
			surveyMap.put(cpt, absserie.fct());
			cpt++;
		}
		model3.addAttribute("surveyMap", surveyMap);
		return "getSerieLe";
	}
	@PostMapping("/ProgrammeLegs/exercice/{id}")
	public String storee(Model model, @PathVariable Long id, @ModelAttribute LegsSerie s) {
		this.service.LegsAddSerieForAnExercice(s, id);
		return "redirect:/ProgrammeLegs/exercice/{id}";
	}
}
