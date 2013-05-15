<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="db.Customer"%>
    <%@ page import="java.util.List"%>
<jsp:useBean id="customers" scope="request" type="List<Customer>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String id = "";
		out.println("<table border='1'><tr bgcolor=lightgrey><th>kood</th></tr>");
		try {
			for (Customer c : customers) {
				id = Integer.toString(c.getCustomer());
				out.println("<tr><td>" + id + "</td></tr>");
			}
			out.println("</table>");
		} catch (Exception ex) {
			out.println("Mingi viga" + ex.getMessage());
		}		
	%>
	
<form action="pricelist?action=searchcustomer" method="POST">
		<input type="text" name="customer">
		<input type="submit" value="Otsi" />
</form>
</body>
</html>