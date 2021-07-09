package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseMaterial;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repos.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	@Test
	public void saveCourseMAterial() {

		Course course = Course.builder().courseTitle("python").credit(200).build();
		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
		courseMaterialRepository.save(courseMaterial);
	}

	@Test
	public void getAllCourseMAterials() {
		List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
		System.out.println(courseMaterials);
	}

}
