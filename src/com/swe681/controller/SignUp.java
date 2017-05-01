package com.swe681.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swe681.services.DatabaseService;
import com.swe681.services.HashPassword;

/**
 * Servlet implementation class SignUp
 */
//@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		System.out.println("-------------- inside doPost-----------------");
		
		String fname= request.getParameter("fname");
		String lname= request.getParameter("lname");
		String uname= request.getParameter("username");
		String email= request.getParameter("email");
		String pword= request.getParameter("createPassword");
		
		
		System.out.println(fname+lname+uname+email+pword);
		DatabaseService ds = new DatabaseService();
		StringBuilder svalidation= new StringBuilder();
		svalidation=ds.validation(email, fname, lname, uname, pword);
		System.out.println(svalidation);
		if(svalidation==null || svalidation.length()<1)
		{
			RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		else
		{
			pw.print(svalidation);
			RequestDispatcher rd= request.getRequestDispatcher("/signup.jsp");
			rd.include(request, response);
		}
		
		HashPassword hp = new HashPassword();
		
		ds.InsertUser(email, fname, lname, uname, pword);
		
		
	}

}
