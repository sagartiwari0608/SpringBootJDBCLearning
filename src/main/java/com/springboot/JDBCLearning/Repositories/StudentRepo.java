package com.springboot.JDBCLearning.Repositories;

import com.springboot.JDBCLearning.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student student) {
        String sql = "insert into student (rollno, name, age) values (?,?,?)";

        int rows = jdbc.update(sql,student.getRollNo(),student.getName(),student.getAge());
        System.out.println( rows +" Rows affected");
    }

    public List<Student> findAll() {
        String sql = "select * from student";
//        this is the actual code, but we can reduce it to a lambda function which is what we'll do
//        RowMapper<Student> mapper = new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student s = new Student();
//                s.setRollNo(rs.getInt("rollno"));
//                s.setName(rs.getString("name"));
//                s.setAge(rs.getInt("age"));
//                return s;
//            }
//        };
//        return jdbc.query(sql,mapper);
        return jdbc.query(sql, (rs,rowNum)->{
            Student s = new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
            return s;
        });

    }
}
