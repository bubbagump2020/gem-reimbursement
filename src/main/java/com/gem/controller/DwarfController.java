package com.gem.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.gem.models.Dwarf;
import com.gem.services.DwarfService;

public class DwarfController {
	private DwarfService ds = new DwarfService();
	private static final Logger logger = (Logger) LogManager.getLogger("DwarfController");

	public DwarfController(DwarfService ds) {
		this.ds = ds;
	}

	public DwarfController() {
		// TODO Auto-generated constructor stub
	}
	// rewrite this method to mirror login
	public void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(true);
		session.setAttribute("email", req.getParameter("loginEmail"));
		Dwarf d = new Dwarf(req.getParameter("createEmail"), req.getParameter("createUsername"), req.getParameter("createPassword"));
		int result = ds.create(d);
		if(result == 0) {
			logger.info("Dwarf Created: " + d.toString());
			resp.sendRedirect("html/user.html");
		} else {
			logger.info("Dwarf not created");
			resp.sendRedirect("html/index.html");
		}
		
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Dwarf d = new Dwarf(request.getParameter("loginEmail"), request.getParameter("loginPassword"));
		d = ds.findByUsernamePassword(d);
		request.getSession().setAttribute("userId", d.getId());
		if(d != null) {
			if(d.getRole().equals("overseer")) {
				System.out.println("hitting the overseer true");
				response.sendRedirect("html/overseer.html");
			} else {
				logger.info("Dwarf Login attempt successful");
				response.sendRedirect("html/user.html");
			}
		} else {
			logger.info("Dwarf Login attempt unsuccessful");
			response.sendRedirect("html/index.html");
		}
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
}
