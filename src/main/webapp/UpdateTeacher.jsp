<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.persistence.Persistence" %>
<%@page import="com.hibernate.principle.Teacher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int id=Integer.parseInt(request.getParameter("id"));
   EntityManagerFactory emf=Persistence.createEntityManagerFactory("shridhar");
   EntityManager em=emf.createEntityManager();
   
   Teacher t=em.find(Teacher.class, id);
%>
<form action="updateteacher2" method="post">
Id:<input type="text" value="<%=t.getId() %>" name="id"><br><br>
Name:<input type="text" value="<%=t.getName() %>" name="name"><br><br>
Course:<input type="text" value="<%=t.getCourse() %>"name="course"><br><br>
salary:<input type="text" value="<%=t.getSalary() %>"name="salary"><br><br>
<input type="submit">
</table>
</body>
</html>