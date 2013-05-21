<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.AttributeModel"%>
<%@page import="db.Item"%>
<%@page import="java.util.List"%>
<%@page import="model.SearchForm"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Toote otsing</title>

<script type="text/javascript">
var req;
var my_divid;
var mozillus = 0;
var appserver_url = "http://localhost:8080/R11_ladu/";

function Initialize_dc()
{
    try
    {
        req=new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch(e)
    {
        try
        {
            req=new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch(oc)
        {
            req=null;
        }
    }

    if(!req&&typeof XMLHttpRequest!="undefined")
    {
        req= new XMLHttpRequest();
        mozillus = 1;

}


} 

function ShowDiv(divid)
{
   if (document.layers) document.layers[divid].visibility="show";
   else document.getElementById(divid).style.visibility="visible";
}

function HideDiv(divid)
{
   if (document.layers) document.layers[divid].visibility="hide";
   else document.getElementById(divid).style.visibility="hidden";
}

function show_toode_form()
{

ShowDiv("toode_form");
}

function evaluate_toode_form(id,nimetus)
{
document.forms['toode_form'].id.value = id;
document.forms['toode_form'].nimetus.value = nimetus;

}

function show_tooted(id,nimetus)
{
show_toode_form();
evaluate_toode_form(id,nimetus);
}

function hide_toode_form()
{

HideDiv("toode_form");

}


function get_toode(id)
    {


  Initialize_dc(); 
    var start = new Date(); 
    var tm=start.getTime();
    var url=appserver_url + "product?id="+id+'&tm='+tm;
    url = encodeURI(url);
    if(req!=null)
    {
        req.onreadystatechange = Process_toode_request;
        req.open("GET", url, true);
        req.send(null);

    }


    }
 
 function Process_toode_request()
{
  var x;

    if (req.readyState == 4)
        {
        

            if (req.status == 200)
            {
                if(req.responseText=="")
                { x = 1 ; }
                else
                {   

                    if (mozillus == 1)
                    {
                    var toode = JSON.parse(req.responseText);
                    }
                    else
                    {
                    
                    var toode = JSON.parse(req.responseText);
                    }
                    var id = item.getItem();
                    var nimetus = item.getName();
                    var kirjeldus=item.getDescription;
                    var muugihind=getValue(item.getSalePrice());
                    var laohind=item.getStorePrice();
                    	
                    show_tooted(id,nimetus);
                    
                   
                }
            }
            else
            {
                document.getElementById("ajax_response").innerHTML=
                 "Oli mingi probleem andmete saamisega: "+req.statusText;
            }
        }


}
</script>
</head>
<body>

<div class="cl-main-box">
<%@ include file="logout.jsp" %>
	<h3>Toote otsing</h3>
	<%if(request.getAttribute("form") != null){
	    SearchForm form = (SearchForm) request.getAttribute("form");%>
	
	<form action="" method="POST">
		<table>
		<tr><td>Nimetus</td><td><input type="text" name="name" value="<%=form.getName()%>"/></td></tr>
		<tr><td>Kirjeldus</td><td><input type="text" name="description"  value="<%=form.getDescription()%>"/></td></tr>
		<tr><td>Tootja kood</td><td><input type="text" name="producer_code"  value="<%=form.getProducerCode()%>"/></td></tr>
		<tr><td>Tootja</td><td><input type="text" name="producer" value="<%=form.getProducer()%>" /></td></tr>
		<tr><td>Arv laos</td><td><input type="text" name="quantity" value="<%=form.getQuantity()%>" /></td></tr>
		<tr><td>Müügihind</td><td><input type="text" name="sale_price" value="<%=form.getSalePrice()%>" /></td></tr>
		<tr><td>Laohind</td><td><input type="text" name="store_price" value="<%=form.getStorePrice()%>" /></td></tr>
		<%if(form.getAttributes().size() == 0){
		    out.println("<tr><td>Attribuut</td><td><input type='text' name='attribute' value='"+form.getAttribute()+"'/></td></tr>");
		}else{
		    out.println("<tr><td colspan'2'>------------ attribuudid ---------</td></tr>");
		    out.println("<tr><td>Toote tüüp</td><td>"+form.getType()+
			    "<input type='hidden' name='type' value='"+form.getType()+"'/></td></tr>");
		    for(Long key : form.getAttributes().keySet()){
			AttributeModel current = form.getAttributes().get(key);
			out.println("<tr><td>"+current.getAttributeName()+"</td><td><input type='text' name='"+key+"' value='"
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
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nimetus</th>
					<th>Kirjeldus</th>
					<th>Müügi hind</th>
					<th>Lao hind</th>
					<th>Tootja</th>
					<th>Tootja kood</th>
					<th></th>
					<th></th>
					<th></th>
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
			    out.println("<td><a href='javascript:get_toode("+item.getItem()+")' TARGET='_self'>Ava</a></td>");
			    out.println("<td><a href='"+request.getContextPath()+"/product?id="+item.getItem()+"'>Muuda</a></td>");
			    out.println("<td><a href='"+request.getContextPath()+"/warehouse?item="+item.getItem()+"'>Lao toiming</a></td>");
			    out.println("</tr>");
			} %>
			</tbody>
		</table>
		<%
		    	}
		    }
		%>
	</div>
	
	 <br>
<br> 
<div ID="ajax_response">
</div>
<div ID="toode_form" style="visibility:hidden;">
<form name=toode_form>
		<table>
		
<tr ><td  COLSPAN=2>Toode</td></tr>
<tr ><td  nowrap>id</td><td ><input type=text name=id size=4 disabled></TD></tr>
<tr ><td  nowrap>nimetus:</td><td ><input type=text name=nimetus size=4 disabled></TD></tr>
<tr ><td  nowrap COLSPAN=2><input type="button" value="KINNI" onClick="hide_toode_form()"></TD></tr>

			
		</table>
		

</form>
</div>
	
	</div>
</body>
<%! private String getValue(Object o){
    if(o != null){
		return o.toString();
    }else{
		return "";
    }
}%>