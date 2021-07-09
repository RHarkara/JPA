package com.example.demo;


import com.example.demo.entity.Guardian;
import com.example.demo.entity.Student;
import com.example.demo.repos.CourseMaterialRepository;
import com.example.demo.repos.CourseRepository;
import com.example.demo.repos.StudentRepository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	Guardian gaurdian = Guardian.builder()
						.name("prabhakae")
						.email("hprao@gmail.com")
						.mobileNumber("8956234")
						.build();

	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.firstName("Rohith")
				.lastName("Harkara")
				.emailId("harkara.rohithk@gmail.com")
//				.guardianName("prabhakar")
//				.guardianEmail("hp@gmail.com")
//				.guardianMobile("9999999999")
				.build();
		studentRepository.save(student);

	}
	
	@Test
	public void saveStudentWithGuardian() {
		Student student1 = Student.builder()
							.firstName("naveen")
							.lastName(null)
							.emailId("nr@gmail.com")
							.guardian(gaurdian)
							.build();
		studentRepository.save(student1);
	}
	
	@Test
	public void getAllStudents() {
		System.out.println(studentRepository.findAll());

	}
	
	@Test
	public void findStudentByFirstName() {
		List<Student> students = studentRepository.findByFirstName("Harkara");
		System.out.println(students);
	}
	
	@Test
	public void findByMatchingContent() {
		List<Student> students = studentRepository.findByFirstNameContaining("Ro");
		System.out.println(students);
	}
	@Test
	public void findByNotNUll() {
		List<Student> students = studentRepository.findByLastNameNotNull();
		System.out.println(students);
	}
	
	@Test
	public void findBymailID() {
		Student s = studentRepository.getStudentByEmailAddress("hr@gmail.com");
		System.out.println(s);
	}
	@Test
	public void UpdateBymailID() {
		studentRepository.updateStudentNameByEmailId("Rohith Hunk", "hr@gmail.com");
		
	}
	
	
	

}
