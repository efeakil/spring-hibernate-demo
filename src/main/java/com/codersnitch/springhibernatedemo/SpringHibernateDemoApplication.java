package com.codersnitch.springhibernatedemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.codersnitch.springhibernatedemo.dao.StudentDAO;
import com.codersnitch.springhibernatedemo.entity.Student;

@SpringBootApplication
public class SpringHibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};

	} 

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Us");
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create Student object
		Student tempStudent = new Student("Onur", "Güvenme", "dopest@gmail.com");

		studentDAO.save(tempStudent);

		System.out.println("Student saved : " + tempStudent.getId());

		Student retrievedStudent = studentDAO.findById(tempStudent.getId());

		System.out.println("Retrieved Student : " + retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating 3 student object..");
		Student tempStudent1 = new Student("Efe", "Us", "snitch@gmail.com");
		Student tempStudent2 = new Student("Alperen", "Kacan", "qincha@gmail.com");
		Student tempStudent3 = new Student("Yigit", "Sevmeyen", "lui@gmail.com");

		// save the student object
		System.out.println("Saving 3 student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating student object..");
		Student tempStudent = new Student("Paul", "Walker", "paulwalker@gmail.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
