package com.situ.shixun.dao;

import java.util.List;

import com.situ.shixun.pojo.Student;

public interface IStudentDao {
	/**
	 * 添加学生
	 * @param student
	 * @return true:添加成功  false:添加失败
	 */
	public abstract boolean add(Student student);
	
	public abstract boolean deleteById(int id);
	
	public abstract boolean update(Student student);
	
	public abstract List<Student> findAll();
	
	public abstract List<Student> findByName(String name);
	public abstract List<Student> findByAge(int age);
	public abstract List<Student> findByGender(String gender);

	/*
	 * 判断这个用户的名字在数据库里面存不存在
	 * 
	 */
	public abstract boolean checkName(String name);

	public abstract Student findById(int id);
	

}
