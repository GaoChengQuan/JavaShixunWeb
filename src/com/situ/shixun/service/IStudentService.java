package com.situ.shixun.service;

import java.util.List;

import com.situ.shixun.pojo.Student;

public interface IStudentService {

	List<Student> findAll();

	boolean add(Student student);

	boolean deletById(int parseInt);

}
