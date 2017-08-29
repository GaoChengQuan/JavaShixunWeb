package com.situ.shixun.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.situ.shixun.dao.IStudentDao;
import com.situ.shixun.dao.impl.StudentDaoImpl;
import com.situ.shixun.pojo.Student;
import com.situ.shixun.util.JdbcUtil;

public class StudentDaoImplTest {
	public static void main(String[] args) {
		Student student = new Student("zs", 28, "男", "市南");
		//addStudent(student);
		//findAll();
	}
	
	@Test
	public void testAdd() {
		Student student = new Student("uu", 20, "男", "青岛");
		IStudentDao studentDao = new StudentDaoImpl();
		boolean result = studentDao.add(student);
		if (result) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}


	private static void findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6、关闭
			JdbcUtil.close(resultSet, statement, connection);
		}
	}
}
