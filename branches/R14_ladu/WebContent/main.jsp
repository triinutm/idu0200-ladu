<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="db.UserAccount"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<html>
<head>
<link rel="stylesheet" href ="r_14.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pealeht</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>

<body>
<%@ include file="logout.jsp" %>
<a class="green-button" href='<%=request.getContextPath()%>/pricelist'>Hinnakirjad</a>
<% if(request.getAttribute("lastCatalog") != null){%>
    <a class="green-button" href="<%=request.getContextPath() + "/insert?catalog="+request.getParameter("catalog")%>">Lisa toode</a>
    <a class="green-button" href="<%=request.getContextPath() + "/search?catalog="+request.getParameter("catalog")%>">Otsi</a>
 <% out.println("<br><strong>Valitud: " + request.getAttribute("lastCatalog")+" </strong><br>");
} else{
    out.println("<a class='green-button' href='" + request.getContextPath()+"/search'>Otsi</a>");
}
out.println("<br><br>");
String categorytree = (String)request.getAttribute("categoryTree"); 
out.println(categorytree); %>
<br>
<br>
<a class="button" href='static/pictures/klassidiagramm.jpg'>Klassidiagramm</a>
<a class="button" href='static/pictures/ladude_jadadiagramm.jpg'>Ladude jadadiagramm</a>
<a class="button" href='static/pictures/sisse_logimise_jadadiagramm.jpg'>Sisselogimise jadadiagramm</a>
<a class="button" href='static/sql/f_leia_kliendid.sql.txt'>f_leia_kliendid.sql</a>
<a class="button" href='static/sql/f_uuenda_lao_hinda.sql.txt'>f_uuenda_lao_hinda.sql</a>
<a class="button" href='http://hektor4.ttu.ee/tomcat_webapp_logs/r14_ladu/log.txt'>log.txt</a>
</body>
</html>