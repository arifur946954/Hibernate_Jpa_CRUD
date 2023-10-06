package com.crud.Crud;

import com.crud.Crud.daos.StudentDao;
import com.crud.Crud.entitys.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication

public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner->{
//createStudent(studentDao);
			readStudent(studentDao);
			queryForStudent(studentDao);
		};
	}

	private void queryForStudent(StudentDao studentDao) {
	List<Student> thStudent= studentDao.findByAll();
	for (Student tempStudent : thStudent){
		System.out.println(tempStudent);

	}
	}

	private void readStudent(StudentDao studentDao) {
		//create student
		Student tempStudent=new Student("Sarif","ahmed","sarif@gmail.com");
		//save
		studentDao.save(tempStudent);
		//display
		int thId= tempStudent.getId();
	Student idf=	studentDao.findById(thId);
		System.out.println("ID is :" +idf);

		//retrive student
	}

//	private void createStudent(StudentDao studentDao) {
//		//create student object
//		System.out.println("create new student: ");
//     Student tempStudent =new Student("Rejuan","Ahmed","rejuan@gmail.com");
//		//save student obj
//	studentDao.save(tempStudent);
//		System.out.println("register successfully");
//
//		//show student
//		System.out.println("output is "+tempStudent.getId()+"Email:"+tempStudent.getEmail());
//	}

}
