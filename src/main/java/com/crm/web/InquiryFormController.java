package com.crm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InquiryFormController {
	
	@GetMapping("inquiry_form")
	public String index(Model model) {
		model.addAttribute("page_title", "Home Page");
		return "inquiry_form";
	}

}
