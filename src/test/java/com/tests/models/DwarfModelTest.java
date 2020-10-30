package com.tests.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.gem.models.Dwarf;

public class DwarfModelTest {
	private Dwarf d;
	
	@Before
	public void setup() {
		d = new Dwarf(100, "test4@test.com", "password",
				"thisUsername", "firstName", "lastName", "miner");
	}
	@Test
	public void toStringTest() {
		Dwarf dTest = new Dwarf(100, "test4@test.com", "password",
				"thisUsername", "firstName", "lastName", "miner");
		assertEquals(d.toString(), dTest.toString());
	}
	
	@Test
	public void setEmailTest() {
		d.setEmail("test5@test.com");
		assertEquals("test5@test.com", d.getEmail());
	}
	
	@Test
	public void setPasswordTest() {
		d.setPassword("pass");
		assertEquals("pass", d.getPassword());
	}
	
	@Test
	public void setUsernameTest() {
		d.setUsername("myUsername");
		assertEquals("myUsername", d.getUsername());
	}
	
	@Test
	public void setFirstNameTest() {
		d.setFirstName("myFirstName");
		assertEquals("myFirstName", d.getFirstName());
	}
	
	@Test
	public void setLastNameTest() {
		d.setLastName("myLastName");
		assertEquals("myLastName", d.getLastName());
	}
	
	
	@Test
	public void setRoleIdTest() {
		d.setRoleId(1);
		assertEquals(1, d.getRoleId());
	}
	
	@Test
	public void setRole() {
		d.setRole("overseer");
		assertEquals("overseer", d.getRole());
	}
	@Test
	public void getIdTest() {
		int id = d.getId();
		assertEquals(100, id);
	}
	
	@Test
	public void dwarfNoArgConstructorTest() {
		Dwarf dTest = null;
		dTest = new Dwarf();
		assertNotNull(dTest);
	}
	
	@Test
	public void getRole() {
		String role = d.getRole();
		assertEquals("miner", role);
	}
}
