package com.tests.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.gem.models.Dwarf;
import com.gem.services.DwarfService;
import com.github.javafaker.Faker;

public class DwarfServiceTest {
	private DwarfService ds;
	
	@Before
	public void setup() {
		ds = new DwarfService();
	}
	
	@Test
	public void findByUsernamePassword() {
		Dwarf d = null;
		d = ds.findByUsernamePassword(new Dwarf("CYBA", "password"));
		assertNotNull(d);
	}
	
	@Test
	public void createTest() {
		Faker faker = new Faker();
		String email = faker.artist().name();
		String username = faker.company().industry();
		
		Dwarf d = new Dwarf(
					email,
					username,
					"password"
				);
		int result = ds.create(d);
		assertEquals(0, result);
	}
}
