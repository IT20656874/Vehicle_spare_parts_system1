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
	
	<center><div class="card pt-5 pr-5 pl-5 pb-5" style="width:50%;align-items:left">
	<center><h2>Edit Payment Details</h2></center>
	<%
		String pid =(String)request.getAttribute("pid");
		PaymentDb pd=new PaymentDb();
		ResultSet rs=pd.getOnePayment(pid);
		while(rs.next()){
	%>
		<form action="<%= request.getContextPath() %>/PaymentManagement" method="post">
			<div class="form-group">
				<lable>Name : </lable>
				<input type="text" name="name" value="<%=rs.getString("carholder_name") %>" class="form-control">
			</div>
			<div class="form-group">
				<lable>Amount : </lable>
				<input type="number" name="amount" value="<%=rs.getString("amount") %>" class="form-control">
			</div>
			<div class="form-group">
				<lable>Card No : </lable>
				<input type="number" name="cardno" value="<%=rs.getString("card_number") %>" class="form-control">
			</div>
			<div class="form-group">
				<lable>csv : </lable>
				<input type="number" name="csv" value="<%=rs.getString("csv") %>" class="form-control">
			</div>
			<div class="form-group">
				<lable>Expire Date : </lable>
				<input type="date" name="exdate" value="<%=rs.getString("expire_date") %>" class="form-control">
			</div>
			
			<input type="text" name="pid" value="<%=pid %>" hidden>
			<input type="submit" name="update" value="Update" class="btn btn-primary" >
			<input type="reset" name="clear" value="Clear" class="btn btn-primary" >
		</form>
		<%} %>
	</div></center>
</body>
</html>