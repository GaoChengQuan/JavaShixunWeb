package com.situ.shixun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.shixun.pojo.Student;
import com.situ.shixun.service.IStudentService;
import com.situ.shixun.service.impl.StudentServiceImpl;

public class FindAllStudentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IStudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.findAll();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<a href='/JavaShixunWeb/add_student.html'>添加</a>");
		printWriter.println("<table align='center' border='1' cellSpacing='0'>");
		printWriter.println("	<tr>");
		printWriter.println("		<td>id</td>");
		printWriter.println("		<td>名字</td>");
		printWriter.println("		<td>年龄</td>");
		printWriter.println("		<td>性别</td>");
		printWriter.println("		<td>地址</td>");
		printWriter.println("		<td>删除</td>");
		printWriter.println("		<td>修改</td>");
		printWriter.println("	</tr>");
		for (Student student : list) {
			printWriter.println("	<tr>");
			printWriter.println("		<td>" + student.getId() + "</td>");
			printWriter.println("		<td>" + student.getName() + "</td>");
			printWriter.println("		<td>" + student.getAge() + "</td>");
			printWriter.println("		<td>" + student.getGender() + "</td>");
			printWriter.println("		<td>" + student.getAddress() + "</td>");
			printWriter.println("		<td><a href=/JavaShixunWeb/deleteStudent?id="+student.getId()+">删除</a></td>");
			printWriter.println("		<td><a href=/JavaShixunWeb/toUpdateStudent?id="+student.getId()+">修改</a></td>");
			printWriter.println("	</tr>");
		}
		printWriter.println("</table>");
		printWriter.close();
	}
	
}
