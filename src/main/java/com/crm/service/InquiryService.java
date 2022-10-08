package com.crm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.InquiryRepository;
import com.crm.domain.Inquiry;
import com.crm.dto.InquiryDto;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class InquiryService {

	@Autowired
	InquiryRepository repository;

	public boolean add(InquiryDto inquiryDto) {
		Inquiry domain = new Inquiry();
		BeanUtils.copyProperties(inquiryDto, domain);
		domain = repository.save(domain);
		if (domain.getId() != null) {
			return true;
		}
		return false;
	}
	
	
	
}
