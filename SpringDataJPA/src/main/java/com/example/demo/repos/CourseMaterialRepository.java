package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
