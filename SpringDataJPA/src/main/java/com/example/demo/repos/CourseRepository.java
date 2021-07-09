package com.example.demo.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByCourseTitleContaining(String title,Pageable pageable);

}
