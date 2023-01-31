package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.principle.Teacher;

@WebServlet("/updateteacher2")
public class UpdateTeacherServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String course=req.getParameter("course");
		double salary=Double.parseDouble(req.getParameter("salary"));
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shridhar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher t1=new Teacher();
		t1.setId(id);
		t1.setName(name);
		t1.setCourse(course);
		t1.setSalary(salary);
		
		et.begin();
		em.merge(t1);
		et.commit();
		
		PrintWriter out=resp.getWriter();
		out.print("<html><body><h1>Data Updated.......</h1></body></h1>");
		
	}

}
