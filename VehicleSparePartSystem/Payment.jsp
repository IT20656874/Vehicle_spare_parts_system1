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
	<div class="card">
	<center><h2>Add Payment</h2></center>
		<form action="<%= request.getContextPath() %>/PaymentManagement" method="post">
			<div class="form-group">
				<lable>Name : </lable>
				<input type="text" name="name" class="form-control" placeholder="Name">
			</div>
			<div class="form-group">
				<lable>Amount : </lable>
				<input type="number" name="amount" class="form-control" >
			</div>
			<div class="form-group">
				<lable>Card No : </lable>
				<input type="number" name="cardno" class="form-control">
			</div>
			<div class="form-group">
				<lable>csv : </lable>
				<input type="number" name="csv" class="form-control" >
			</div>
			<div class="form-group">
				<lable>Expire Date : </lable>
				<input type="date" name="exdate" class="form-control" >
			</div>
			<input type="submit" name="submit" value="Add to Payment" class="btn btn-primary">
			<input type="reset" name="clear" value="Clear" class="btn btn-primary">
		</form>
	</div>
</body>
</html>