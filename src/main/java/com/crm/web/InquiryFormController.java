package com.crm.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crm.dto.InquiryDto;
import com.crm.service.InquiryService;

@Controller
@RequestMapping("")
public class InquiryFormController {
	
	@Autowired
	InquiryService service;
	
	@GetMapping("/inquiry_form")
	public String index(@RequestParam(value = "id", required = false) Long id, InquiryDto inquiryDto, Model model) {
		if(id == null) {
			inquiryDto = new InquiryDto();
		}else {
			inquiryDto = service.findById(id);
		}
		
		model.addAttribute("inputform", inquiryDto);
		model.addAttribute("page_title", "Home Page");
		return "inquiry/inquiry_form";
	}
	
	@PostMapping("/inquiry_form/add")
	public String add(@Valid @ModelAttribute("inputform") InquiryDto inquiryDto, RedirectAttributes model,  BindingResult errors, SessionStatus status) {	

		model.addFlashAttribute("stauts", "Failed !");
	    model.addFlashAttribute("message", "Error Please Enter Valid Data !");
	    model.addFlashAttribute("alertClass", "alert-danger");
	    if (errors.hasErrors()) {
	        return "redirect:/inquiry/inquiry_form";
	    }
	    
	    service.add(inquiryDto);
	    status.setComplete();
	    model.addFlashAttribute("stauts", "Success !");
	    model.addFlashAttribute("message", "Record Saved Successfully !");
	    model.addFlashAttribute("alertClass", "alert-success");
	    return "redirect:/inquiry_form";
	}
	
	@PostMapping("inquiry_form/edit")
	public String edit(Model model, InquiryDto inquiryDto) {
		System.out.println(inquiryDto);
		service.add(inquiryDto);
		model.addAttribute("page_title", "Home Page");
		model.addAttribute("inputform", new InquiryDto());
		
		return "inquiry_form";
	}
	
//	@PostMapping("inquiry_form/delete")
//	public String delete(Model model, InquiryDto inquiryDto) {
//		System.out.println(inquiryDto);
//		service.add(inquiryDto);
//		model.addAttribute("page_title", "Home Page");
//		model.addAttribute("inputform", new InquiryDto());
//		
//		return "inquiry_form";
//	}

	@GetMapping("inquiry_list")
	public String list(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam(name = "value", required = false) String value) {
		
		if (value != null) {
            model.addAttribute("key", value);
            model.addAttribute("data", service.findByNamaContainingIgnoreCase(value, pageable));
        } else {
            model.addAttribute("data", service.findAll(pageable));
        }
		
		return "inquiry/inquiry_list";
	}

}
