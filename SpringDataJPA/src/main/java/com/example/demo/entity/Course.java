package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
	@Id
	@SequenceGenerator(
			name = "course_sequence",
			sequenceName = "course_sequence",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "course_sequence")
	private Long courseId;
	private String courseTitle;
	private Integer credit;
	
	@OneToOne(
			mappedBy = "course")
	private CourseMaterial courseMaterial; // To make it Bi-Directional instead of Uni Directional
	
	/*
	 * OneToMany and ManyToOne structure of table will be same but
	 * representation will be different
	 * Always try to do bidirectional Relationship without cascading written
	 */	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id",
				referencedColumnName = "teacherId"
				)
	private Teacher teacher;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_course_map",
			joinColumns = @JoinColumn(
					name = "course_id",
					referencedColumnName = "courseId"),
			inverseJoinColumns = @JoinColumn(
					name = "student_id",
					referencedColumnName = "studentId"))
	/*
	 * As It is ManyToMany Relationship we need to create an another table instead
	 * of creating a foreign key for a table and this is how we will do it
	 */	
	
	private List<Student> students;
	
	public void addStudents(Student student) {
		if(students == null) {
			students = new ArrayList<>();
			students.add(student);
		}
	}

}
