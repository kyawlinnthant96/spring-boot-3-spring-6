package com.kltdev.cruddemo;

import com.kltdev.cruddemo.dao.StudentDAO;
import com.kltdev.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
		createMultipleStudents(studentDAO);
		// readStudent(studentDAO);
		// queryForStudents(studentDAO);
		// updateStudent(studentDAO);
		// deleteStudent(studentDAO);
		// deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Delete All Student");
		int numRowsDeleted = studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Delete student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student base on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change firstname to bob
		System.out.println("Updating the student");
		myStudent.setFirstName("Bob");

		// update the student
		studentDAO.update(myStudent);

		// display update the student
		System.out.println("Updating the student: " + myStudent);

	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a lists of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student template : theStudents) {
			System.out.println(template);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Create new student object...");
		Student tempStudent = new Student("Darl", "Darry", "darldary@gmail.com");

		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// displaying id of the save student
		int theId = tempStudent.getId();
		System.out.println("Save student, generate Id: " + theId);

		// retrieve student base on id
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student" + myStudent);


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
