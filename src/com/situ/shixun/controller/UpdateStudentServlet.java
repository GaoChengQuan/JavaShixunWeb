package com.situ.shixun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.shixun.pojo.Student;
import com.situ.shixun.service.IStudentService;
import com.situ.shixun.service.impl.StudentServiceImpl;

public class UpdateStudentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		Student student = new Student(Integer.parseInt(id), name, Integer.parseInt(age), gender, address);
		IStudentService studentService = new StudentServiceImpl();
		boolean result = studentService.update(student);
		if (result) {
			System.out.println("更新成功");
			resp.sendRedirect("/JavaShixunWeb/findAllStudent");
		} else {
			System.out.println("更新失败");
		}
	}
}
