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

@WebServlet("/removeteacher")
public class RemoveTeacherServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shridhar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher t1=em.find(Teacher.class, id);
		
		et.begin();
		em.remove(t1);
		et.commit();
		
		PrintWriter out=resp.getWriter();
		out.print("Data removed.......");
	}

}
