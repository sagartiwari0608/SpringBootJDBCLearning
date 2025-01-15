package com.springboot.JDBCLearning;

import com.springboot.JDBCLearning.Services.StudentService;
import com.springboot.JDBCLearning.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcLearningApplication {

	public static void main(String[] args)
	{

		ApplicationContext context= SpringApplication.run(JdbcLearningApplication.class, args);
		Student student = context.getBean(Student.class);
		student.setAge(16);
		student.setRollNo(1);
		student.setName("Sagar");

		StudentService studentService = context.getBean(StudentService.class);
		studentService.addStudent(student);
	}

}
