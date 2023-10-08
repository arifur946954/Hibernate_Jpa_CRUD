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
			//readStudent(studentDao);
			//queryForStudent(studentDao);
			//queryForStudentByLastNAme(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			deleteAllStudent(studentDao);



		};
	}

	private void deleteAllStudent(StudentDao studentDao) {
		System.out.println("delete all student from database");
	int umRowDeleted=	studentDao.deleteAll();
		System.out.println("after deleting"+umRowDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {
		//set id which one i want to delete
		int stId=3;
		//
		studentDao.delete(stId);
	}

	private void updateStudent(StudentDao studentDao) {
		//retrive student based on id
		int studentId=1;
		System.out.println("studentId is:"+studentId);
	Student myStudent=	studentDao.findById(studentId);

		//change first name to xyz
		System.out.println("Updating name:");
		myStudent.setFirstName("Mr Rahman");

		//update the student
		studentDao.updates(myStudent);
		//display the student
		System.out.println(myStudent);
	}


	private void queryForStudentByLastNAme(StudentDao studentDao) {
		List<Student> thStudent=studentDao.findByLastName("ahmed");
		for (Student lastNames :thStudent){
			System.out.println("last nanme is: "+lastNames);

		}

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

	private void createStudent(StudentDao studentDao) {
		//create student object
		System.out.println("create new student: ");
     Student tempStudent =new Student("Arifur","rahman","arif@gmail.com");
		//save student obj
	studentDao.save(tempStudent);
		System.out.println("register successfully");

		//show student
		System.out.println("output is "+tempStudent.getId()+"Email:"+tempStudent.getEmail());
	}

}
