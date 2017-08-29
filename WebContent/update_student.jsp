<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.situ.shixun.pojo.Student;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<style type="text/css">
			.align-center{
				margin: 10px auto;
			}
		</style>
</head>
<body>
	<%
		Student student = (Student)request.getAttribute("student");
	%>
	<!--<form action="/JavaShixunWeb/updateStudent">
			<input type="hidden" name="id" value="<%=student.getId() %>"/>
		姓名：<input type="text" name="name" value="<%=student.getName() %>"/><br/>
		年龄：<input type="text" name="age"  value="<%=student.getAge() %>"/><br/>
		性别：<input type="text" name="gender"  value="<%=student.getGender() %>"/><br/>
		地址：<input type="text" name="address"  value="<%=student.getAddress() %>"/><br/>
		<input type="submit" value="修改"/>
	</form>-->
	
	<div class="align-center" style="width: 500px;">
		<h3>修改学生</h3>
		<form action="/JavaShixunWeb/updateStudent" method="get"> 
			<input type="hidden" name="id" value="<%=student.getId() %>"/>
			<div class="form-group">
				<label for="exampleInputName">Name</label>
				<input type="name" name="name" value="<%=student.getName() %>" class="form-control" id="exampleInputName" placeholder="Name">
			</div>
			<div class="form-group">
				<label for="exampleInputAge">Age</label>
				<input type="age" name="age" value="<%=student.getAge() %>" class="form-control" id="exampleInputAge" placeholder="Age">
			</div>
			<div class="form-group">
				<label for="exampleInputGender">Gender</label>
				<input type="gender" name="gender" value="<%=student.getGender() %>" class="form-control" id="exampleInputGender" placeholder="Gender">
			</div>
			<div class="form-group">
				<label for="exampleInputAddress">Address</label>
				<input type="address" name="address"  value="<%=student.getAddress() %>" class="form-control" id="exampleInputAddress" placeholder="Address">
			</div>
			<button type="submit" class="btn btn-success">修改</button>
		</form>
			
	</div>
</body>
</html>