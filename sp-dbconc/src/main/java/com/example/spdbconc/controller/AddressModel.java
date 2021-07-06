package com.example.spdbconc.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Created table for address
 */
@NoArgsConstructor
@Getter
@Setter
public class AddressModel {
	private Long addHouseNumber;

	@NotNull(message = "streetname should not be null")
	@Size(min = 2, message = "StreetName atleast should have 2 characters")
	private String addStreetName;

	@NotNull(message = "city should not be null")
	@Size(min = 2, message = "City atleast should have 2 characters")
	private String addCity;

	}
