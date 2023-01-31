package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.principle.Principle;

@WebServlet("/insertDetails")
public class Servlet1 extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		int mobile=Integer.parseInt(req.getParameter("mobile"));
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shridhar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Principle p1=new Principle();
		p1.setName(name);
		p1.setAge(age);
		p1.setEmail(email);
		p1.setPassword(password);
		p1.setMobile(mobile);
		
		et.begin();
		em.persist(p1);
		et.commit();
		
		PrintWriter out=resp.getWriter();
		out.print("....Accounts Created Successfully...");
		
		RequestDispatcher rd=req.getRequestDispatcher("LogIn.html");
		rd.forward(req, resp);
		
		
		
	}

}
