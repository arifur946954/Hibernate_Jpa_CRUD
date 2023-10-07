package com.crud.Crud.daos;

import com.crud.Crud.entitys.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    //implement save mathod
    void save(Student theStudent);
 Student  findById(Integer id);
 List<Student> findByAll();
    List<Student> findByLastName(String thelastName);
    void updates(Student theStudent);







}
