package com.crm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.domain.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
	
	Page<Inquiry> findByCustomerNameContainingIgnoreCase(String nama, Pageable pageable);

}
