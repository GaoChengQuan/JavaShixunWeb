package com.situ.shixun.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.shixun.pojo.Student;
import com.situ.shixun.service.IStudentService;
import com.situ.shixun.service.impl.StudentServiceImpl;

public class SearchByNameServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nameSearch = req.getParameter("nameSearch");
		IStudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.findByName(nameSearch);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/list_student.jsp").forward(req, resp);
	}
}
