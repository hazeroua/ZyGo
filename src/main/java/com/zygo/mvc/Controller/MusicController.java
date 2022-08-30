package com.zygo.mvc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zygo.mvc.Service.MusicService;

@Controller
public class MusicController {
	@Autowired
	private MusicService musicSerive;
	@GetMapping("/Music")
	public String MusicIndex(Model model) {
		model.addAttribute("musics", musicSerive.getAllMusic());
		return "Music";
	}
}
