package com.kltdev.cruddemo;

import com.kltdev.cruddemo.dao.StudentDAO;
import com.kltdev.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Create 3 students object");
		Student student1 = new Student("Jhone", "Doe", "jhondoe@gmail.com");
		Student student2 = new Student("Mary", "Jane", "maryjane@gmail.com");
		Student student3 = new Student("Kelvin", "Powell", "kelvinpowell@gmail.com");

		System.out.println("Saving students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// creating student object
		System.out.println("Creating new student obj");
		Student tempStudent = new Student("Pault", "Johnson", "paul@101gmail.com");

		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of save student
		System.out.println("Save student, Generated Id: " + tempStudent.getId());

	}

}
