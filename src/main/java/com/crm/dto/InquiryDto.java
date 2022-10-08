package com.crm.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InquiryDto {
	private String customerName;
	private Long mobileNumber;
	private String address;
	private String lookingFor;
	private String configuration;
	private Long budget;
	private String referenceFrom;
}
