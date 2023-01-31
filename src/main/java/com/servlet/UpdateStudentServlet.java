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

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String course=req.getParameter("course");
		double fee=Double.parseDouble(req.getParameter("fee"));
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shridhar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s1=new Student();
		s1.setId(id);
		s1.setName(name);
		s1.setCourse(course);
		s1.setFee(fee);
		
		et.begin();
		em.merge(s1);
		et.commit();
		
		PrintWriter out=resp.getWriter();
		out.print("<html><body><h2>Data Updated....</h2></body></html>");
		
		/*RequestDispatcher rd=req.getRequestDispatcher("Student.html");
		rd.forward(req, resp);*/
		
		
	}
	
	

}
