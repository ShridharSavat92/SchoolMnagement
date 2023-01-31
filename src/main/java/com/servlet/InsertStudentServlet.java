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

import com.hibernate.principle.Student;

@WebServlet("/insert")
public class InsertStudentServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String course=req.getParameter("course");
		double fee=Double.parseDouble(req.getParameter("fee"));
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shridhar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s1=new Student();
		s1.setName(name);
		s1.setCourse(course);
		s1.setFee(fee);
		
		et.begin();
		em.persist(s1);
		et.commit();
		
		PrintWriter out=resp.getWriter();
		out.print("Data Inserted.......");
		
		RequestDispatcher rd=req.getRequestDispatcher("Student.html");
		rd.forward(req, resp);
		
		
	
	}
	

}
