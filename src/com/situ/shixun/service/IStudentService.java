package com.situ.shixun.service;

import java.util.List;

import com.situ.shixun.pojo.Student;

public interface IStudentService {

	List<Student> findAll();

	boolean add(Student student);

	boolean deletById(int parseInt);

	Student findById(int id);

	boolean update(Student student);

}
