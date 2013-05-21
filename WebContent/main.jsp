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

<div class="cl-main-box">
<table>
<tr><td>
<%@ include file="logout.jsp" %> 
</td>
<td>
<a href='<%= request.getContextPath()%>/pricelist'>Hinnakirjad</a>
</td></tr>
</table>
<%
UserAccount user=(UserAccount)request.getSession().getAttribute("user");
%>


<% if (user != null) {%>
<h1>Tere <%=user.getUsername()%>!</h1>
<% }%>
<%if(request.getAttribute("lastCatalog") != null){
    out.println("Valitud: " + request.getAttribute("lastCatalog")+" <br>");
    %>
    <a href="<%=request.getContextPath() + "/insert?catalog="+request.getParameter("catalog")%>">Lisa toode</a><br>
    <a href="<%=request.getContextPath() + "/search?catalog="+request.getParameter("catalog")%>">Otsi</a>
<%}else{
    out.println("<a href='" + request.getContextPath()+"/search'>Otsi</a>");
}%> 
<br />
<br />
<%String categorytree = (String)request.getAttribute("categoryTree"); %>
<%out.println(categorytree);%>
<br />
</div>
</body>
</html>