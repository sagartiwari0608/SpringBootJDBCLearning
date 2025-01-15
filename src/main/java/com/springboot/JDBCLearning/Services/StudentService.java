package com.springboot.JDBCLearning.Services;

import com.springboot.JDBCLearning.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void addStudent(Student student){
        System.out.println("student added "+ student.toString());
    }
}
