<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="db.PriceList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="pricelistElements" scope="request"
	type="List<PriceList>" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hinnakirjad</title>
</head>
<script>
function open_new(){
	document.getElementById("new").reset();
	if (document.layers) document.layers["new_div"].visibility="show";
	else document.getElementById("new_div").style.visibility="visible";
}
function close_new(){
	if (document.layers) document.layers["new_div"].visibility="hide";
	else document.getElementById("new_div").style.visibility="hidden";
}
</script>
<body>



<script>
function getNote(id){

	var xmlhttp;    
    if (id==""){
       document.getElementById("note").innerHTML="";
       return;
    }
    if (window.XMLHttpRequest){
       xmlhttp=new XMLHttpRequest();
    }
    else{
       xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
       if (xmlhttp.readyState==4 && xmlhttp.status==200){
        	kuvaInfo = JSON.parse(xmlhttp.responseText);
      document.getElementById("note").innerHTML= "<b>Märkused</b> : "+ kuvaInfo.note + "<br>";
      	
       }
    }
       xmlhttp.open("GET","pricelists?id="+id,true);
       xmlhttp.send();
 
}
</script>


	<%@ include file="logout.jsp"%>
	<%
		String id = "";
		String status = "";
		String discount = "";
		String date_from = "";
		String date_to = "";
		String note = "";
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		out.println("<table border='1'><tr bgcolor=lightgrey><th>kood</th><th>staatus</th><th>allahindluse protsent</th><th>kehtimise algus</th><th>kehtimise l6pp</th><th></th><th></th><th></th></tr>");
		try {
			for (PriceList p : pricelistElements) {
				id = Long.toString(p.getPriceList());
				status = p.getPriceListStatusType().getTypeName();
				discount = Long.toString(p.getDefaultDiscountXtra());
				date_from = df.format(p.getDateFrom());
				date_to = df.format(p.getDateTo());
				out.println("<tr><td>" + id + "</td><td>" + status
						+ "</td><td>" + discount + "</td><td>" + date_from
						+ "</td><td>" + date_to + "</td><td><a HREF='pricelist?id="+ id
								+ "'TARGET='_self'><strong>muuda</strong></a></td>"+ 
						"</td><td><a HREF='pricelist?action=delete&uid="+ id
						+ "'TARGET='_self'><strong>kustuta</strong></a></td>"
						+"<td nowrap><a href=\"javascript:getNote("+id+")\">märkused</a></td></tr>");
			}
			out.println("</table><input type=button onclick='open_new()' value='Loo uus'><br><br>");
		} catch (Exception ex) {
			out.println("Mingi viga: " + ex.getMessage());
		}		
	%>
   <div id="note"></div>
   
	<div id="new_div" style="visibility: hidden;"><%@ include file="newpricelist.jsp"%>
	<input type=button onclick='close_new()' value='Kinni'> </div>
</body>
</html>