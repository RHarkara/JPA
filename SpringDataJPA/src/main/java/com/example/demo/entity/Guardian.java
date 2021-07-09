package com.example.demo.entity;

import javax.persistence.AttributeOverride; 
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
	
		@AttributeOverride(
				name = "email",
				column = @Column(name = "guardian_email")
				),
		@AttributeOverride(
				name = "mobileNumber",
				column = @Column(name = "guardian_mobile")
				),
		@AttributeOverride(
				name = "name",
				column = @Column(name = "guardian_name")
				)		
		})
public class Guardian {
	
	private String name;
	private String email;
	private String mobileNumber;
	

}
