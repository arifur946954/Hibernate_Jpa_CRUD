package com.crud.Crud;

import com.crud.Crud.daos.StudentDao;
import com.crud.Crud.entitys.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner->{
createStudent(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao) {
		//create student object
		System.out.println("create new student: ");
     Student tempStudent =new Student("shahid","Afridi","afridi@gmail.com");
		//save student obj
	studentDao.save(tempStudent);
		System.out.println("register successfully");

		//show student
		System.out.println("output is "+tempStudent.getId()+"Email:"+tempStudent.getEmail());
	}

}
