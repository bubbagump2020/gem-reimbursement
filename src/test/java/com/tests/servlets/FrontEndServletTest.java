package com.tests.servlets;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gem.servlet.FrontEndServlet;

public class FrontEndServletTest {
	private FrontEndServlet fes;
	
	@Before
	public void setup() {
		fes = new FrontEndServlet();
	}
	
	@Test
	public void doGetTest() {
		
	}
}
