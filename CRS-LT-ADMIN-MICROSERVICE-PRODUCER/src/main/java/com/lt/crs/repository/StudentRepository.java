package com.lt.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lt.crs.model.Student;
/**
 * 
 * @author user215
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

	
	
}
