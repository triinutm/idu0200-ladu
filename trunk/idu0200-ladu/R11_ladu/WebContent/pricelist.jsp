<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="pricelist" scope="request" type="model.PriceListForm" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hinnakiri</title>
</head>
<body>
	<form action="pricelist?action=update" method="POST">
		<input type="hidden" name="id" value='<%=pricelist.getId()%>'>
		<table border="1">
			<tr>
				<th>staatus</th>
				<td><select name="status" id="status">		
						<option value="1" >pooleli</option>
						<option value="2">kinnitatud</option>
				</select></td>
			</tr>
			<tr>
				<th>allahindluse protsent</th>
				<td><input type="text" name="discount"
					value="<%=pricelist.getDefaultDiscountXtra()%>" /></td>
			</tr>
			<tr>
				<th>kehtimise algus</th>
				<td><input type="text" name="date_from"
					value="<%=pricelist.getDateFrom()%>" /></td>
			</tr>
			<tr>
				<th>kehtimise lõpp</th>
				<td><input type="text" name="date_to"
					value="<%=pricelist.getDateTo()%>" /></td>
			</tr>
			<tr>
				<th>märkus</th>
				<td><textarea name="note" rows="8" cols="35"><%=pricelist.getNote()%></textarea></td>
			</tr>
		</table>
		<input type="submit" value="salvesta">
	</form>
</body>
</html>