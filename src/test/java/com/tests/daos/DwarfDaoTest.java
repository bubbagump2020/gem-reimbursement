package com.tests.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gem.daos.DwarfDao;
import com.gem.models.Dwarf;
import com.github.javafaker.Faker;

public class DwarfDaoTest {
	private DwarfDao dd;
	
	@Before
	public void setup() {
		dd = new DwarfDao();
	}
	
	@Test
	public void findAllTest() {
		List<Dwarf> allDwarves = null;
		allDwarves = dd.findAll();
		assertNotNull(allDwarves);
	}
	
	@Test
	public void findByUsernamePasswordTest() {
		Dwarf d = null;
		d = dd.findByUsernamePassword(new Dwarf("CYBA", "password"));
		assertNotNull(d);
	}
	
//	@Test
//	public void createTest() {
//		Faker faker = new Faker();
//		String email = faker.animal().name();
//		String username = faker.ancient().hero();
//		Dwarf d = new Dwarf(
//					email,
//					username,
//					"password"
//				);
//		int result = dd.create(d);
//		assertEquals(0, result);
//	}
	
	@Test
	public void updateDwarfTest() {
		int result = 0;
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		Dwarf d = new Dwarf(
					"CYBA",
					null,
					"password",
					firstName,
					lastName
					
				);
		
		result = dd.updateDwarf(d);
		assertEquals(1, result);
	}
}
