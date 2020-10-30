package com.gem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.controller.DwarfController;
import com.gem.controller.ReimbursementController;


public class RoutingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	public void whichRoute(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println(request.getSession().getAttribute("userId"));
		switch(request.getRequestURI()) {
			case "/user.page":
				response.sendRedirect("html/user.html");
				break;
			case "/login.page":
				new DwarfController().login(request, response);
				break;
			case "/logout.page":
				request.getSession().invalidate();
				response.sendRedirect("html/index.html");
				break;
			case "/create-user.page":
				new DwarfController().create(request, response);
				break;
			default:
				response.sendRedirect("html/index.html");
				break;
		}
	}
	
	public void returnData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		switch(request.getRequestURI()) {
			case "/reimbursement.json":
				new ReimbursementController().create(request, response);
				break;
			case "/user_reimbursements.json":
				new ReimbursementController().sendUserAll(request, response);
				break;
			case "/all_reimbursements.json":
				new ReimbursementController().sendAll(request, response);
				break;
			case "/update_reimbursement.json":
				new ReimbursementController().update(request, response);
				break;
		}
	}
}
