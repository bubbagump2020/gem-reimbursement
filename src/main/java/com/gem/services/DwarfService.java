package com.gem.services;

import javax.naming.NamingException;

import com.gem.daos.DwarfDao;
import com.gem.models.Dwarf;

public class DwarfService {
	private DwarfDao dd = new DwarfDao();

	public DwarfService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Dwarf findByUsernamePassword(Dwarf d) {
		return dd.findByUsernamePassword(d);
	}
	
	public int create(Dwarf d) {
		return dd.create(d);
	}
	
	// need some login where it brings back the username, but unhashes the salt and checks it against the password input by the user
	
}
