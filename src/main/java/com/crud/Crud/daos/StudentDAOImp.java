package com.crud.Crud.daos;

import com.crud.Crud.entitys.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    @Transactional
    @Override
    public void save(Student theStudent) {
    entityManager.persist(theStudent);


    }
}
