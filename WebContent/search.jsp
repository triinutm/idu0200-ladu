<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.AttributeModel"%>
<%@page import="db.Item"%>
<%@page import="java.util.List"%>
<%@page import="model.SearchForm"%>
<html>

<head>
<link rel="stylesheet" href ="r_14.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Toote otsing</title>
</head>
<body>
<%@ include file="logout.jsp" %>
	<h3>TOOTE OTSING</h3>
	<%if(request.getAttribute("form") != null){
	    SearchForm form = (SearchForm) request.getAttribute("form");%>
	
	<form action="" method="POST">
		<table border='1'>
		<tr><th bgcolor=lightgrey>Nimetus</th><td><input type="text" name="name" value="<%=form.getName()%>"/></td></tr>
		<tr><th bgcolor=lightgrey>Kirjeldus</th><td><input type="text" name="description"  value="<%=form.getDescription()%>"/></td></tr>
		<tr><th bgcolor=lightgrey>Tootja kood</th><td><input type="text" name="producer_code"  value="<%=form.getProducerCode()%>"/></td></tr>
		<tr><th bgcolor=lightgrey>Tootja</th><td><input type="text" name="producer" value="<%=form.getProducer()%>" /></td></tr>
		<tr><th bgcolor=lightgrey>Arv laos</th><td><input type="text" name="quantity" value="<%=form.getQuantity()%>" /></td></tr>
		<tr><th bgcolor=lightgrey>Müügihind</th><td><input type="text" name="sale_price" value="<%=form.getSalePrice()%>" /></td></tr>
		<tr><th bgcolor=lightgrey>Laohind</th><td><input type="text" name="store_price" value="<%=form.getStorePrice()%>" /></td></tr>
		<%if(form.getAttributes().size() == 0){
		    out.println("<tr><th  bgcolor=lightgrey>Attribuut</th><td><input type='text' name='attribute' value='"+form.getAttribute()+"'/></td></tr>");
		}else{
		    out.println("<tr><td align='center' colspan='2'><strong>Attribuudid</strong></td></tr>");
		    out.println("<tr><th bgcolor=lightgrey>Toote tüüp</th><td><strong>"+form.getType()+
			    "<input type='hidden' name='type' value='"+form.getType()+"'/></strong></td></tr>");
		    for(Long key : form.getAttributes().keySet()){
			AttributeModel current = form.getAttributes().get(key);
			out.println("<tr><th bgcolor=lightgrey>"+current.getAttributeName()+"</th><td><input type='text' name='"+key+"' value='"
			+current.getAttributeValue()+"' /><input type='hidden' name='"+key+"'value='"+current.getAttributeName()+"' /></td></tr>");
		    }
		} %>
		</table>
		<input type="submit" value="Otsi" />
	</form>
	<%} %>
	<div>
		<%
		    if (request.getAttribute("items") != null) {
				List<Item> items = (List<Item>) request.getAttribute("items");
				if (items != null && items.size() > 0) {
		%>
		<br>
		<table border='1'>
			<thead>
				<tr>
					<th bgcolor=lightgrey>Kood</th>
					<th  bgcolor=lightgrey>Nimetus</th>
					<th  bgcolor=lightgrey>Kirjeldus</th>
					<th  bgcolor=lightgrey>Müügi hind</th>
					<th  bgcolor=lightgrey>Lao hind</th>
					<th  bgcolor=lightgrey>Tootja</th>
					<th  bgcolor=lightgrey>Tootja kood</th>
					<th  bgcolor=lightgrey></th>
					<th  bgcolor=lightgrey></th>
				</tr>
			</thead>
			<tbody>
			<%for(Item item : items){
			    out.println("<tr>");
			    out.println("<td>"+item.getItem()+"</td>");
			    out.println("<td>"+item.getName()+"</td>");
			    out.println("<td>"+item.getDescription()+"</td>");
			    out.println("<td>"+getValue(item.getSalePrice())+"</td>");
			    out.println("<td>"+getValue(item.getStorePrice())+"</td>");
			    out.println("<td>"+item.getProducer()+"</td>");
			    out.println("<td>"+item.getProducerCode()+"</td>");
			    out.println("<td><a class='button' href='"+request.getContextPath()+"/product?id="+item.getItem()+"'>Muuda</a></td>");
			    out.println("<td><a class='button' href='"+request.getContextPath()+"/warehouse?item="+item.getItem()+"'>Lao toiming</a></td>");
			    out.println("</tr>");
			} %>
			</tbody>
		</table>
		<%
		    	}
		    }
		%>
	</div>
</body>
<%! private String getValue(Object o){
    if(o != null){
		return o.toString();
    }else{
		return "";
    }
}%>