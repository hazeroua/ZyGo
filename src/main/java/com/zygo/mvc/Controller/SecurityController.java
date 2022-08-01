package com.zygo.mvc.Controller;

import java.util.LinkedHashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zygo.mvc.Repository.UserRepository;
import com.zygo.mvc.Service.PectoralsService;
import com.zygo.mvc.entities.Exercice;
import com.zygo.mvc.entities.Serie;
import com.zygo.mvc.entities.User;


@Controller
public class SecurityController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PectoralsService service;
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	@GetMapping("/index")
	public String index1() {
		return "index";
	}
	@GetMapping("/ProgrammePectoral/{username}")
	public String pectoralsindex(Model model,@PathVariable String username) {
		model.addAttribute("exercice", this.service.getAllExoByUsername(username));
		return "pectoralsProgramme";
	}
	@GetMapping("/addEP/{username}")
	public String add(Model model, Model model2, @PathVariable String username) {
		model2.addAttribute("username", userRepo.findByUsername(username));
		model.addAttribute("exercice", new Exercice());
		return "addExoP";
	}
	@PostMapping("/addEP/{username}")
	public String store(@ModelAttribute Exercice e, Model model, @PathVariable String username) {
		model.addAttribute("username", userRepo.findByUsername(username));
		this.service.saveExercice(e, username);
		return "redirect:/ProgrammePectoral/{username}";
	}
	@GetMapping("/ProgrammePectoral/exercice/{id}")
	public String series(Model model2,Model model,Model model3, @PathVariable Long id ) {
		model.addAttribute("exercice", service.findByIdE(id));
		Exercice e = service.findByIdE(id);
		model.addAttribute("allSerie", service.getAllSerieByEx(e));
		model2.addAttribute("serie", new Serie());
		Map<Integer, Double> surveyMap = new LinkedHashMap<>();
		int cpt=0;
		for(Serie absserie : e.getSeries() ) {
			surveyMap.put(cpt, absserie.fct());
			cpt++;
		}
		model3.addAttribute("surveyMap", surveyMap);
		return "getSerieP";
	}
	@PostMapping("/ProgrammePectoral/exercice/{id}")
	public String storee(Model model, @PathVariable Long id, @ModelAttribute Serie s) {
		this.service.addSerieForAnExercice(s, id);
		return "redirect:/ProgrammePectoral/exercice/{id}";
	}
	@PostMapping("/ProgrammePectoral/exercice/delete/{id}")
	public String deleteSerie(@ModelAttribute Serie s) {
		this.service.deleteSerie(s);
		return "redirect:/ProgrammePectoral/exercice/{id}";
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	     
	    return "register";
	}
	@PostMapping("/register")
	public String processRegister(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	     
	    userRepo.save(user);
	     
	    return "register_success";
	}
}
