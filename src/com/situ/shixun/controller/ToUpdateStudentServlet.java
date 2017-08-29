package com.situ.shixun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.shixun.pojo.Student;
import com.situ.shixun.service.IStudentService;
import com.situ.shixun.service.impl.StudentServiceImpl;

public class ToUpdateStudentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		IStudentService studentService = new StudentServiceImpl();
		Student student = studentService.findById(Integer.parseInt(id));
		//把student放到request域对象中
		req.setAttribute("student", student);
		req.getRequestDispatcher("/update_student.jsp").forward(req, resp);
	}
}
