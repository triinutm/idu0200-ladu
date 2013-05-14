<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="db.PriceList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uus hinnakiri</title>
</head>
<body>
<form action="pricelist?action=new" method="POST">
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
				<td><input type="text" name="discount"/></td>
			</tr>
			<tr>
				<th>kehtimise algus</th>
				<td><input type="text" name="date_from"/></td>
			</tr>
			<tr>
				<th>kehtimise lõpp</th>
				<td><input type="text" name="date_to"/></td>
			</tr>
			<tr>
				<th>märkus</th>
				<td><textarea name="note" rows="8" cols="35"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="salvesta">
	</form>
</body>
</html>