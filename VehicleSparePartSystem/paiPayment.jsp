<%@page import="java.sql.ResultSet"%>
<%@page import="dbPayment.PaymentDb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div class="card pt-5 pr-5 pl-5">
	<center><h2>Paid Payment Details</h2></center>
		<table class="table table-dark">
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Amount</th>
				<th scope="col">CardNo</th>
				<th scope="col">Csv</th>
				<th scope="col">Expire Date</th>
			</tr>
		
		<%
			PaymentDb pd=new PaymentDb();
			ResultSet rs= pd.selectSuccessPayment();
			while(rs.next()){
		%>
		
		<tr>
			<td scope="row"><%=rs.getString("carholder_name") %></td>
			<td><%=rs.getString("amount") %></td>
			<td><%=rs.getString("card_number") %></td>
			<td><%=rs.getString("csv") %></td>
			<td><%=rs.getString("expire_date") %></td>
			
		</tr>	
		<%} %>
		
		</table>
	</div>
</body>
</html>