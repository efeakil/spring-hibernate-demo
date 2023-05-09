package com.codersnitch.springhibernatedemo.dao;

import java.util.List;

import com.codersnitch.springhibernatedemo.entity.Student;

public interface StudentDAO {
    
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();


}
