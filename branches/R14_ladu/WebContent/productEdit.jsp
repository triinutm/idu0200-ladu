<%@page import="model.AttributeModel"%>
<%@page import="model.ProductModel"%>
<%@page import="db.TypeAttribute"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href ="r_14.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Toote andmete muutmine</title>
</head>
<body>
<%@ include file="logout.jsp" %>
<h3>TOOTE ANDMETE MUUTMINE</h3>
<%
if(request.getAttribute("productModel") != null){
    ProductModel model = (ProductModel) request.getAttribute("productModel");
%>
<form action="" method="POST">
<table border='1'>
<tr><th  bgcolor=lightgrey>Nimetus</th><td><input type="text" name="name" value="<%=model.getName().getAttributeValue()%>"/>
<span><%=model.getName().getErrorMessage()%></span></td></tr>
<tr><th  bgcolor=lightgrey>Kirjeldus</th><td><input type="text" name="description" value="<%=model.getDescription().getAttributeValue()%>" />
<span><%=model.getDescription().getErrorMessage()%></span></td></tr>
<tr><th  bgcolor=lightgrey>Müügihind</th><td><input type="text" name="price" value="<%=model.getPrice().getAttributeValue()%>"/>
<span><%=model.getPrice().getErrorMessage()%></span></td></tr>
<tr><th colspan="2" style="text-align:center; padding:10px 0px; font-size:16px">Atribuudid</th></tr>
<%
    for(Long key : model.getAttributes().keySet()){
		AttributeModel attributeModel = model.getAttributes().get(key);
		out.println("<tr><th  bgcolor=lightgrey>"+attributeModel.getAttributeName()+"</th><td>");
		out.println("<input type='text' name='"+key+"' placeholder='"
		+attributeModel.getAttributeName()+"' value='"+attributeModel.getAttributeValue()+"'/>"+
		"<input type='hidden' name='"+key+"'value='"+attributeModel.getAttributeName()+"' />"+
		"<input type='hidden' name='"+key+"'value='"+attributeModel.getAttributeId()+"' />"
		+"<span>"+attributeModel.getErrorMessage()+"</span></td></tr>");
    }
	out.println("<tr><th  bgcolor=lightgrey>Toote tüüp</th><td><strong>"+model.getType()+
	    "<input type='hidden' name='type' value='"+model.getType()+"' />"+
	    "<input type='hidden' name='itemType' value='"+model.getItemType()+"'</strong></td><tr>");
%>
</table><input type="submit" value="Salvesta" />
<div>
<%if(request.getAttribute("error") != null) {
    out.println(request.getAttribute("error"));
}%>
</div>
<input type="submit" name="delete" value="Kustuta" />

<%}else{
    out.println("<p>Sellist toodet pole olemas!</p>");
} %>
</form>

</body>
</html>