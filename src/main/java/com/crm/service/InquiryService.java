package com.crm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crm.InquiryRepository;
import com.crm.domain.Inquiry;
import com.crm.dto.InquiryDto;

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

	public Object findByNamaContainingIgnoreCase(String value, Pageable pageable) {
		return repository.findByCustomerNameContainingIgnoreCase(value, pageable);
	}

	public Object findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public InquiryDto findById(Long id) {
		InquiryDto inquiryDto = new InquiryDto();
		BeanUtils.copyProperties(repository.findById(id).get(), inquiryDto);
		return inquiryDto;
	}
	
	
}
