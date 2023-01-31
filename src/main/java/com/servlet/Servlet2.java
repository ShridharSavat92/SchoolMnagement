package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.principle.Principle;

@WebServlet("/LogIn")
public class Servlet2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shridhar");
		EntityManager em=emf.createEntityManager();
		PrintWriter out=resp.getWriter();
		
		Query q=em.createQuery("select p from Principle p where p.name=?1 and p.password=?2");
		q.setParameter(1, name);
		q.setParameter(2, password);
		
		List<Principle> user=q.getResultList();
		
		if(user.size()>0) {
			out.print("LogIn Successfully....");
			RequestDispatcher rd=req.getRequestDispatcher("StudentTeacherDetails.html");
			rd.forward(req, resp);
		}
		else {
			out.println("<html><body><h1>...Invalid Credential....</h1></body></html>");
		}
	}

}
