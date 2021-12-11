package com.pasteblock.pasteblock.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping({"/", "/home", "/index"})
	public String index(Model model) {
		model.addAttribute("accion", "Home");
		return "index";
	}
}
