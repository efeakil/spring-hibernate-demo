package com.codersnitch.springhibernatedemo;

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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating student object..");
		Student tempStudent = new Student(
			"Paul","Walker","paulwalker@gmail.com"
		);

		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
