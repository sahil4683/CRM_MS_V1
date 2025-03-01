package com.crm.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping(value = {"","/home"})
	public String index(Model model) {
		model.addAttribute("page_title", "Home Page");
		return "home";
	}

}
