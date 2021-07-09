package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repos.CourseRepository;

@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void getCourses() {
		List<Course> courses = courseRepository.findAll();
		System.out.println(courses);
	}

	public Teacher getTeacherDetails() {
		Teacher teacher = Teacher.builder().firstName("Neha").lastName("Sharma").build();
		return teacher;
	}

	@Test
	public void addCourses() {
		Course course = Course.builder().courseTitle("Testing").credit(20).teacher(getTeacherDetails()).build();
		courseRepository.save(course);
	}

	@Test
	public void findAllPAgination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable firstPageWithTwoRecords = PageRequest.of(1, 2);

		List<Course> courses = courseRepository.findAll(firstPageWithTwoRecords).getContent();
		Long elements = courseRepository.findAll(firstPageWithTwoRecords).getTotalElements();
		Integer totalPages = courseRepository.findAll(firstPageWithTwoRecords).getTotalPages();

		System.out.println("courses : " + courses);
		System.out.println("Total Elements : " + elements);
		System.out.println("Total Pages : " + totalPages);

	}

	@Test
	public void findAllPaginationBySorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("courseTitle"));
		Pageable sortByCreditDec = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDec = PageRequest.of(0, 2,
				Sort.by("courseTitle").descending().and(Sort.by("credit")));
		List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
		System.out.println("courses " + courses);

	}
	
	@Test
	public void printFindBytitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		List<Course> courses = courseRepository.findByCourseTitleContaining("p", firstPageTenRecords);
		System.out.println("cources"+ courses);
		
	}
	
	public List<Student> getStudents() {
		Student student1 = Student.builder()
							.firstName("Rohith")
							.lastName("Harkara")
							.emailId("hhh@gmail.com")
							.build();
		Student student2 = Student.builder()
				.firstName("Rishi")
				.lastName("Harkara")
				.emailId("hrh@gmail.com")
				.build();
		List<Student> students = List.of(student1,student2);
		return students;
							
	}

	@Test
	public void saveCoursewithStudentAndTeacher() {
		
		Teacher teacher = Teacher.builder()
						.firstName("ameer")
						.lastName("khan")
						.build();
		Course course = Course.builder()
						.courseTitle("AI")
						.credit(20)
						.teacher(teacher)
						.students(getStudents())
						.build();
		courseRepository.save(course);
		
	}

}
