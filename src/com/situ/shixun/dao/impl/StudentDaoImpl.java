package com.situ.shixun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.situ.shixun.dao.IStudentDao;
import com.situ.shixun.pojo.Student;
import com.situ.shixun.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao{

	@Override
	public boolean add(Student student) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean isSuccess = false;
		//2、获取连接对象Connection。
		try {
			connection = JdbcUtil.getConnection();
			//3、写sql语句。
			String sql = "INSERT INTO student(NAME,age,gender,address) VALUES(?,?,?,?);";
			//4、创建Satement。
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());
			statement.setString(3, student.getGender());
			statement.setString(4, student.getAddress());
			//5、执行sql语句。
			//  更新：delete/update/insert   executeUpdate   返回值int表示影响的行数。
			//  查询：select                         executeQuery       返回结果集ResultSet。
			int result  = statement.executeUpdate();
			if (result > 0) {
				isSuccess = true;
			}
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(statement, connection);
		}
		return isSuccess;
	}

	@Override
	public boolean deleteById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean isSuccess = false;
		//2、获取连接对象Connection。
		try {
			connection = JdbcUtil.getConnection();
			//3、写sql语句。
			String sql = "delete from student where id=?;";
			//4、创建Satement。
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			//5、执行sql语句。
			//  更新：delete/update/insert   executeUpdate   返回值int表示影响的行数。
			//  查询：select                         executeQuery       返回结果集ResultSet。
			int result  = statement.executeUpdate();
			if (result > 0) {
				isSuccess = true;
			}
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(statement, connection);
		}
		return isSuccess;
	
	}

	@Override
	public boolean update(Student student) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean isSuccess = false;
		//2、获取连接对象Connection。
		try {
			connection = JdbcUtil.getConnection();
			//3、写sql语句。
			String sql = "UPDATE student SET NAME=?,age=?,gender=?,address=? WHERE id=?;";
			//4、创建Satement。
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());
			statement.setString(3, student.getGender());
			statement.setString(4, student.getAddress());
			statement.setInt(5, student.getId());
			//5、执行sql语句。
			//  更新：delete/update/insert   executeUpdate   返回值int表示影响的行数。
			//  查询：select                         executeQuery       返回结果集ResultSet。
			int result  = statement.executeUpdate();
			if (result > 0) {
				isSuccess = true;
			}
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(statement, connection);
		}
		return isSuccess;
	}

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		//2、获取连接对象Connection。
		try {
			connection = JdbcUtil.getConnection();
			//3、写sql语句。
			String sql = "SELECT * FROM student;";
			//4、创建Satement。
			statement = connection.prepareStatement(sql);
			//5、执行sql语句。
			//  更新：delete/update/insert   executeUpdate   返回值int表示影响的行数。
			//  查询：select                         executeQuery       返回结果集ResultSet。
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Student student = new Student(id, name, age, gender, address);
				System.out.println(student);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6、关闭
			JdbcUtil.close(resultSet, statement, connection);
		}
		
		return list;
	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByGender(String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		//2、获取连接对象Connection。
		try {
			connection = JdbcUtil.getConnection();
			//3、写sql语句。
			String sql = "SELECT * FROM student where name=?;";
			//4、创建Satement。
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			//5、执行sql语句。
			//  更新：delete/update/insert   executeUpdate   返回值int表示影响的行数。
			//  查询：select                         executeQuery       返回结果集ResultSet。
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6、关闭
			JdbcUtil.close(resultSet, statement, connection);
		}
		
		return false;
	}

	@Override
	public Student findById(int idSearch) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		//2、获取连接对象Connection。
		try {
			connection = JdbcUtil.getConnection();
			//3、写sql语句。
			String sql = "SELECT * FROM student where id=?;";
			//4、创建Satement。
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idSearch);
			//5、执行sql语句。
			//  更新：delete/update/insert   executeUpdate   返回值int表示影响的行数。
			//  查询：select                         executeQuery       返回结果集ResultSet。
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Student student = new Student(id, name, age, gender, address);
				System.out.println(student);
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6、关闭
			JdbcUtil.close(resultSet, statement, connection);
		}
		
		return null;
	}

}
