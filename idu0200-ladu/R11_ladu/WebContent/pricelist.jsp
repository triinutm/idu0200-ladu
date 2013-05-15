<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<jsp:useBean id="pricelist" scope="request" type="model.PriceListForm" />
<jsp:useBean id="otherstatus" scope="request"
	type="List<java.lang.String>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hinnakiri</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
	$(function() {
		$("#date_from").datepicker();
		$("#date_to").datepicker();
	});
</script>
</head>
<body>
	<form action="pricelist?action=update" method="POST">
		<input type="hidden" name="id" value='<%=pricelist.getId()%>'>
		<table border="1">
			<tr>
				<th>staatus</th>
				<td><select name="status" id="status">
						<option value='<%=pricelist.getPriceListStatusType()%>'><%=pricelist.getPriceListStatusType()%></option>
						<%for(String s: otherstatus){
							out.println("<option value='"+s+"'>"+s+"</option>");
						}
						%>
				</select></td>
			</tr>
			<tr>
				<th>allahindluse protsent</th>
				<td><input type="text" name="discount"
					value="<%=pricelist.getDefaultDiscountXtra()%>" /></td>
			</tr>
			<tr>
				<th>kehtimise algus</th>
				<td><input READONLY type="text" name="date_from" id="date_from"
					value="<%=pricelist.getDateFrom()%>" /></td>
			</tr>
			<tr>
				<th>kehtimise lõpp</th>
				<td><input READONLY type="text" name="date_to" id="date_to"
					value="<%=pricelist.getDateTo()%>" /></td>
			</tr>
			<tr>
				<th>märkus</th>
				<td><textarea name="note" rows="8" cols="35"><%=pricelist.getNote()%></textarea></td>
			</tr>
		</table>
		<input type="submit" value="salvesta" />
	</form>
</body>
</html>