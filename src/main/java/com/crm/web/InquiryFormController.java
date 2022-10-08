package com.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm.dto.InquiryDto;
import com.crm.service.InquiryService;

@Controller
@RequestMapping("")
public class InquiryFormController {
	
	@Autowired
	InquiryService service;
	
	@GetMapping("/inquiry_form")
	public String index(Model model) {
		model.addAttribute("page_title", "Home Page");
		model.addAttribute("inputform", new InquiryDto());
		
		return "inquiry_form";
	}
	
	@PostMapping("inquiry_form/add")
	public String add(Model model, InquiryDto inquiryDto) {
		System.out.println(inquiryDto);
		service.add(inquiryDto);
		model.addAttribute("page_title", "Home Page");
		model.addAttribute("inputform", new InquiryDto());
		
		return "inquiry_form";
	}

}
