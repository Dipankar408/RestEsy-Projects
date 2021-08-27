package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;


import org.jboss.resteasy.plugins.providers.html.View;

import com.db.Customer;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Path("/")
public class CustomerResource {

	@Inject
	CustomerService cs;
	
	@GET
	public View displayAllCustomer() {
		List<Object> clist=cs.showAllCustomer();
		return new View("/index.jsp",clist,"clist");
	}
	
	@POST
	@Path("save")
	public void save(@Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException, ServletException{
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String num=req.getParameter("number");
		long pin=Long.parseLong(req.getParameter("pin"));
		String city=req.getParameter("city");
		String district=req.getParameter("dist");
		String state=req.getParameter("state");
		String pass=req.getParameter("pass");
		cs.createCustomer(id,name,age,num,pin,city,district,state,pass);
		
		req.setAttribute("msg", "Success");
		RequestDispatcher rd=req.getRequestDispatcher("/test.jsp");
		rd.forward(req, resp);
		resp.getWriter().println("Successfully saved");
	}
	
	@GET
	@Path("show")
	public void firstPage(@Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException, ServletException {
		List<Object> clist=cs.showAllCustomer();
		List<Object> nlist=cs.showNumbers();
		
		req.setAttribute("cust", clist);
		req.setAttribute("nums", nlist);
		RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
		
	}
	
	@POST
	@Path("loggingIn")
	public void login(@Context HttpServletRequest req, @Context HttpServletResponse resp) throws IOException, ServletException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String pass=req.getParameter("pass");
		RequestDispatcher rd=req.getRequestDispatcher("/test.jsp");
		String msg="";
		if(cs.login(id, pass))
		{
			msg="Success";
			req.setAttribute("msg", msg);
			rd.forward(req, resp);
		}
		else
		{
			msg="Failed";
			req.setAttribute("msg", msg);
			rd.forward(req, resp);
		}
	}
	
	@GET
	@Path("login/{id}")
	public View login(@PathParam("id") int id) {
		return new View("/login.jsp",id,"id");
	}
	
}
