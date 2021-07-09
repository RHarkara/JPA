package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import com.example.demo.repos.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository repository;
	
	public List<Course> courses() {
		Course course1 = Course.builder()
						 .courseTitle(".NET")
						 .credit(10)
						 .build();
		Course course2 = Course.builder()
						 .courseTitle("Testing")
						 .credit(15)
						 .build();
		List<Course> courses = List.of(course1,course2);
		return courses;
	}
	
	@Test
	public void saveTeacher() {
		Teacher teacher = Teacher.builder()
						  .firstName("Ram")
						  .lastName("Laxman")
						  //.courses(courses())
						  .build();
		repository.save(teacher);
	}

}
