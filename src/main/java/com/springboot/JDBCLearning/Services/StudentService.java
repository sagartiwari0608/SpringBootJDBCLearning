package com.springboot.JDBCLearning.Services;

import com.springboot.JDBCLearning.Repositories.StudentRepo;
import com.springboot.JDBCLearning.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    private StudentRepo repo;
    public void addStudent(Student student){
        System.out.println("student added "+ student.toString());
        repo.save(student);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
