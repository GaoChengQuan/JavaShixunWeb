package com.situ.shixun.service.impl;

import java.util.List;

import com.situ.shixun.dao.IStudentDao;
import com.situ.shixun.dao.impl.StudentDaoImpl;
import com.situ.shixun.pojo.Student;
import com.situ.shixun.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
	private IStudentDao studentDao = new StudentDaoImpl();
	
	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public boolean add(Student student) {
		//判断这个用户的名字在数据库里面存不存在
		if (studentDao.checkName(student.getName())) {
			System.out.println("学生已经存在了");
			return false;
		} else {
			return studentDao.add(student);
		}
	}

	@Override
	public boolean deletById(int id) {
		return studentDao.deleteById(id);
	}

	@Override
	public Student findById(int id) {
		return studentDao.findById(id);
	}

	@Override
	public boolean update(Student student) {
		return studentDao.update(student);
	}

	@Override
	public List<Student> findByName(String nameSearch) {
		return studentDao.findByName(nameSearch);
	}

}
