package com.seo.dj.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlockSearch {
	@NotBlank(message = "Appkey can't not have empty value.")
	@Size(max=3, message = "Appkey must be less 3 length.")
	private String appKey;
}
