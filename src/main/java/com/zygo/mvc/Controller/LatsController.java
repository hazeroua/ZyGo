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
import com.zygo.mvc.Service.LatsService;
import com.zygo.mvc.entities.LatsExercice;
import com.zygo.mvc.entities.LatsSerie;

@Controller
public class LatsController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private LatsService service;
	@GetMapping("/ProgrammeLats/{username}")
	public String pectoralsindex(Model model,@PathVariable String username) {
		model.addAttribute("exercice", this.service.getAllExoByUsername(username));
		return "LatsProgramme";
	}
	@GetMapping("/addEL/{username}")
	public String add(Model model, Model model2, @PathVariable String username) {
		model2.addAttribute("username", userRepo.findByUsername(username));
		model.addAttribute("exercice", new LatsExercice());
		return "addExoL";
	}
	@PostMapping("/addEL/{username}")
	public String store(@ModelAttribute LatsExercice e, Model model, @PathVariable String username) {
		model.addAttribute("username", userRepo.findByUsername(username));
		this.service.saveExercice(e, username);
		return "redirect:/ProgrammeLats/{username}";
	}
	@GetMapping("/ProgrammeLats/exercice/{id}")
	public String series(Model model2,Model model,Model model3, @PathVariable Long id ) {
		model.addAttribute("exercice", service.findByIdEL(id));
		LatsExercice e = service.findByIdEL(id);
		model.addAttribute("allSerie", service.getAllSerieByEx(e));
		model2.addAttribute("serie", new LatsSerie());
		Map<Integer, Double> surveyMap = new LinkedHashMap<>();
		int cpt=0;
		for(LatsSerie absserie : e.getSeriesL() ) {
			surveyMap.put(cpt, absserie.fct());
			cpt++;
		}
		model3.addAttribute("surveyMap", surveyMap);
		return "getSerieL";
	}
	@PostMapping("/ProgrammeLats/exercice/{id}")
	public String storee(Model model, @PathVariable Long id, @ModelAttribute LatsSerie s) {
		this.service.LatsAddSerieForAnExercice(s, id);
		return "redirect:/ProgrammeLats/exercice/{id}";
	}
}
