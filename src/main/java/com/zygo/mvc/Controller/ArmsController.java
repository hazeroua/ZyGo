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
import org.springframework.web.bind.annotation.RequestParam;

import com.zygo.mvc.Repository.UserRepository;
import com.zygo.mvc.Service.ArmsService;
import com.zygo.mvc.entities.ArmsExercice;
import com.zygo.mvc.entities.ArmsSerie;

@Controller
public class ArmsController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ArmsService service;
	@GetMapping("/ProgrammeArms/{username}")
	public String pectoralsindex(Model model,@PathVariable String username) {
		model.addAttribute("exercice", this.service.getAllExoByUsername(username));
		return "ArmsProgramme";
	}
	@GetMapping("/addEA/{username}")
	public String add(Model model, Model model2, @PathVariable String username) {
		model2.addAttribute("username", userRepo.findByUsername(username));
		model.addAttribute("exercice", new ArmsExercice());
		return "addExoA";
	}
	@PostMapping("/addEA/{username}")
	public String store(@ModelAttribute ArmsExercice e, Model model, @PathVariable String username) {
		model.addAttribute("username", userRepo.findByUsername(username));
		this.service.saveExercice(e, username);
		return "redirect:/ProgrammeArms/{username}";
	}
	@GetMapping("/ProgrammeArms/exercice/{id}")
	public String series(Model model2,Model model,Model model3, @PathVariable Long id ) {
		model.addAttribute("exercice", service.findByIdEL(id));
		ArmsExercice e = service.findByIdEL(id);
		model.addAttribute("allSerie", service.getAllSerieByEx(e));
		model2.addAttribute("serie", new ArmsSerie());
		Map<Integer, Double> surveyMap = new LinkedHashMap<>();
		int cpt=0;
		for(ArmsSerie absserie : e.getSeriesA() ) {
			surveyMap.put(cpt, absserie.fct());
			cpt++;
		}
		model3.addAttribute("surveyMap", surveyMap);
		return "getSerieA";
	}
	@PostMapping("/ProgrammeArms/exercice/{id}")
	public String storee(Model model, @PathVariable Long id, @ModelAttribute ArmsSerie s) {
		this.service.ArmsAddSerieForAnExercice(s, id);
		return "redirect:/ProgrammeArms/exercice/{id}";
	}
	@GetMapping("/deleteA")
	public String delete(@RequestParam Long id) {
		this.service.deleteSerie(id);
		return "redirect:/";
	}
	@GetMapping("/deleteExA")
	public String deleteEx(@RequestParam Long id) {
		this.service.deleteExercice(id);
		return "redirect:/";
	}
}
