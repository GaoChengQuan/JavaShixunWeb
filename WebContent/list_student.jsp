<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.situ.shixun.pojo.*"%>
<%@page import="java.util.*"%>
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
		div{
			margin-top:20px;
		}
	</style>
</head>
<body>
	<%
		List<Student> list = (List<Student>)request.getAttribute("list");
	%>
	<div align="center">
		<form action="/JavaShixunWeb/searchByName">
			根据名字搜索<input type="text" name="nameSearch"/>
			<input type="submit" value="搜索"/>
			<a class="btn" href='/JavaShixunWeb/add_student.html'>添加</a>
		</form>
		<table style="width: 500px;" class="table table-striped table-bordered table-hover table-condensed">
			<tr>
				<td>Id</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>性别</td>
				<td>地址</td>
				<td>删除</td>
				<td>修改</td>
			</tr>
			<%
				for (Student student : list) {
			%>
					<tr>
						<td><%=student.getId()%></td>
						<td><%=student.getName()%></td>
						<td><%=student.getAge()%></td>
						<td><%=student.getGender()%></td>
						<td><%=student.getAddress()%></td>
						<td><a href=/JavaShixunWeb/deleteStudent?id=<%=student.getId()%>>删除</a></td>
						<td><a href=/JavaShixunWeb/toUpdateStudent?id=<%=student.getId()%>>修改</a></td>
					</tr>
			<%
				}
				
			%>
		</table>
	</div>
	
</body>
</html>