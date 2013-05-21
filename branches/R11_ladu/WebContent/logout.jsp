<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="db.UserAccount"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css"/>
<title>Insert title here</title>
</head>
<body>
<table>
<%
UserAccount currentuser=(UserAccount)request.getSession().getAttribute("user");
%>
<tr><td>

<% if(currentuser!=null) {%>

<form action="${pageContext.request.contextPath }/" method="post">
<% out.println("<input type=\"submit\" value=\"Logi välja! \"/>"); %>
</form>
<%} %>
</td>
<td>
<% out.println("<a href='" + request.getContextPath() +"/'>Pealeht</a>&nbsp;&nbsp;"); %>
</td>
<td>
<% out.println("<a href='http://www.upload.ee/image/3325625/R11_login_jadadiagramm.jpg'>login jadadiagramm </a>&nbsp;&nbsp;"); %>
</td>
<td>
<% out.println("<a href='http://www.upload.ee/image/3325770/R11_ladu_ladude_jadadiagramm.jpg'>ladude jadadiagramm </a>&nbsp;&nbsp;"); %>
</td>
<td>
<% out.println("<a href='http://www.upload.ee/image/3325617/R11_ladu_klassidiagramm.jpg'>klassidiagramm </a>&nbsp;&nbsp;"); %>
</td></tr>
</table>
</body>
</html>