package com.seo.dj.model;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class BlockSearchTest {
	private static Validator validator;
	
	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void manufacturerIsNull() {
		BlockSearch blockSearch = new BlockSearch();
		blockSearch.setAppKey(null);
		
		Set<ConstraintViolation<BlockSearch>> constraintViolations = validator.validate(blockSearch);

		assertEquals(1, constraintViolations.size());
		assertEquals("Must have a value.", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void manufacturerIsOverSize() {
		BlockSearch blockSearch = new BlockSearch();
		blockSearch.setAppKey("123123123123123");
		
		Set<ConstraintViolation<BlockSearch>> constraintViolations = validator.validate(blockSearch);

		assertEquals(1, constraintViolations.size());
		assertEquals("Must be less 3 length.", constraintViolations.iterator().next().getMessage());
	}
	
	
}
