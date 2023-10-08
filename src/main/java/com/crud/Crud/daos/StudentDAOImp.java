package com.crud.Crud.daos;

import com.crud.Crud.entitys.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImp implements StudentDao {
    //define field entity manager
    private final EntityManager entityManager;
    //inject intity manager  using constructor
@Autowired
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //implement save mathod
    @Transactional//her we couldnt write query
    @Override
    public void save(Student theStudent) {
    entityManager.persist(theStudent);


    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findByAll() {
      //  TypedQuery<Student> thQuery=entityManager.createQuery("FROM Student order by lastName asc", Student.class);
        TypedQuery<Student> thQuery=entityManager.createQuery("FROM Student", Student.class);
    return  thQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String thelastName) {
    TypedQuery<Student> thQuery=entityManager.createQuery("FROM Student Where lastName=:theData",Student.class);
    thQuery.setParameter("theData",thelastName);
        return thQuery.getResultList();
    }

    @Override
    @Transactional
    public void updates(Student theStudent) {
    entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
    //retrive student id fron databse
      Student theStudent=  entityManager.find(Student.class,id);
      //delete student fron database
      entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
    //delete all student
   int numberOfRowDeleted= entityManager.createQuery("DELETE FROM Student").executeUpdate();
   //delete by id from student
        //int numberOfRowDeleted= entityManager.createQuery("DELETE FROM Student WHERE id=5006").executeUpdate();
        return numberOfRowDeleted;
    }


}
