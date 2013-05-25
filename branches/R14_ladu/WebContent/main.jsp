<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="db.UserAccount"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pealeht</title>
</head>

<body>
<%@ include file="logout.jsp" %>
<a href='<%=request.getContextPath()%>/pricelist'>Hinnakirjad</a>
<% if(request.getAttribute("lastCatalog") != null){%>
    <a href="<%=request.getContextPath() + "/insert?catalog="+request.getParameter("catalog")%>">Lisa toode</a>
    <a href="<%=request.getContextPath() + "/search?catalog="+request.getParameter("catalog")%>">Otsi</a>
 <% out.println("<br><strong>Valitud: " + request.getAttribute("lastCatalog")+" </strong><br>");
} else{
    out.println("<a href='" + request.getContextPath()+"/search'>Otsi</a>");
}
out.println("<br><br>");
String categorytree = (String)request.getAttribute("categoryTree"); 
out.println(categorytree); %>
<br>
<br>
<a href='static/pictures/klassidiagramm.jpg'>Klassidiagramm</a>
<a href='static/pictures/ladude_jadadiagramm.jpg'>Ladude jadadiagramm</a>
<a href='static/pictures/sisse_logimise_jadadiagramm.jpg'>Sisselogimise jadadiagramm</a>
<a href='static/sql/f_leia_kliendid.sql.txt'>f_leia_kliendid.sql</a>
<a href='static/sql/f_uuenda_lao_hinda.sql.txt'>f_uuenda_lao_hinda.sql</a>
<a href='http://hektor4.ttu.ee/tomcat_webapp_logs/r14_ladu/log.txt'>log.txt</a>
</body>
</html>