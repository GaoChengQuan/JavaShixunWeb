package com.situ.shixun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.shixun.service.IStudentService;
import com.situ.shixun.service.impl.StudentServiceImpl;

public class DeleteStudentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		IStudentService studentService = new StudentServiceImpl();
		boolean result = studentService.deletById(Integer.parseInt(id));
		if (result) {
			System.out.println("删除成功");
			resp.sendRedirect("/JavaShixunWeb/findAllStudent");
		} else {
			System.out.println("删除失败");
		}
	}
}
