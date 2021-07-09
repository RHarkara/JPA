package com.example.demo.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

/**
 * @author HRK
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameContaining(String name);
	
	public List<Student> findByLastNameNotNull();
	
	public List<Student> findByGuardianName(String gName);
	
	Student findByFirstNameAndLastName(String fName, String lName);
	
	//JPQL --> They are based on the classes we are created
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);
	
	@Query("select s.firstName from Student s where s.emailId = ?1")
	Student getStudentFirstNameByEmailAddress(String emailId);
	
	//Native Query --> They are based on the Table Names not classes
	@Query(value = "select * from tbl_student s where s.email_address = ?1",nativeQuery = true)
	Student getStudentFirstNameByEmailAddressNative(String emailId);
	
	//Native Query --> with param
	@Query(value = "select * from tbl_student s where s.email_address = :emailId",nativeQuery = true)
	Student getStudentFirstNameByEmailAddressNativeParam(@Param("emailId") String emailId);
	
	@Modifying
	@Transactional // Since we are updating the data it is considered as transactional generally it is used in a service layer methods calling repos methods
	@Query(value = "update tbl_student set first_name = ?1 where email_address = ?2",nativeQuery = true)
	int updateStudentNameByEmailId(String firstName,String emailId);

}
