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
import com.zygo.mvc.Service.ShouldersService;
import com.zygo.mvc.entities.ShouldersExercice;
import com.zygo.mvc.entities.ShouldersSerie;
@Controller
public class ShouldersController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ShouldersService service;
	@GetMapping("/ProgrammeShoulders/{username}")
	public String pectoralsindex(Model model,@PathVariable String username) {
		model.addAttribute("exercice", this.service.getAllExoByUsername(username));
		return "ShouldersProgramme";
	}
	@GetMapping("/addES/{username}")
	public String add(Model model, Model model2, @PathVariable String username) {
		model2.addAttribute("username", userRepo.findByUsername(username));
		model.addAttribute("exercice", new ShouldersExercice());
		return "addExoS";
	}
	@PostMapping("/addES/{username}")
	public String store(@ModelAttribute ShouldersExercice e, Model model, @PathVariable String username) {
		model.addAttribute("username", userRepo.findByUsername(username));
		this.service.saveExercice(e, username);
		return "redirect:/ProgrammeShoulders/{username}";
	}
	@GetMapping("/ProgrammeShoulders/exercice/{id}")
	public String series(Model model2,Model model,Model model3, @PathVariable Long id ) {
		model.addAttribute("exercice", service.findByIdEL(id));
		ShouldersExercice e = service.findByIdEL(id);
		model.addAttribute("allSerie", service.getAllSerieByEx(e));
		model2.addAttribute("serie", new ShouldersSerie());
		Map<Integer, Double> surveyMap = new LinkedHashMap<>();
		int cpt=0;
		for(ShouldersSerie absserie : e.getSeriesS() ) {
			surveyMap.put(cpt, absserie.fct());
			cpt++;
		}
		model3.addAttribute("surveyMap", surveyMap);
		return "getSerieS";
	}
	@PostMapping("/ProgrammeShoulders/exercice/{id}")
	public String storee(Model model, @PathVariable Long id, @ModelAttribute ShouldersSerie s) {
		this.service.ShouldersAddSerieForAnExercice(s, id);
		return "redirect:/ProgrammeShoulders/exercice/{id}";
	}
	@GetMapping("/deleteS")
	public String delete(@RequestParam Long id) {
		this.service.deleteSerie(id);
		return "redirect:/";
	}
	@GetMapping("/deleteExS")
	public String deleteEx(@RequestParam Long id) {
		this.service.deleteExercice(id);
		return "redirect:/";
	}
}
