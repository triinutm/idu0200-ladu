<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pealeht</title>
</head>
<body>
<h3>R11 LADU </h3>
<%String categorytree = (String)request.getAttribute("categoryTree"); %>
<%out.println(categorytree); 
if(request.getAttribute("lastCatalog") != null){
    out.println("Valitud: " + request.getAttribute("lastCatalog")+" <br>");
    %>
    <a href="<%=request.getContextPath() + "/insert?catalog="+request.getParameter("catalog")%>">Lisa toode</a><br>
    
<%}%>
</body>
</html>