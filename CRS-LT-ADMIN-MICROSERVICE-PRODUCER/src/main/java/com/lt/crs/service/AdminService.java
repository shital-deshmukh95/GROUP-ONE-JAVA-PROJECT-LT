package com.lt.crs.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.lt.exceptions.CourseExistsAlreadyException;
import com.crs.lt.exceptions.StudentException;
import com.lt.crs.model.Catalog;
import com.lt.crs.model.RegisteredCourse;
import com.lt.crs.model.Student;
import com.lt.crs.repository.AdminRepository;
import com.lt.crs.repository.CatalogRepository;
import com.lt.crs.repository.StudentRepository;

/**
 * 
 * @author user215
 *
 */
@Service
public class AdminService {
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AdminRepository adminRepository ;
	
	@Autowired
	CatalogRepository catalogRepository;

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws StudentException
	 */
	public boolean approveStudentRequest(String studentId) throws StudentException {
		boolean isApprove =  false ;
		Optional<Student> student =  studentRepository.findById(studentId);
		if(student.isPresent()) {
			if("1".equalsIgnoreCase(student.get().getIsApproved())) {
				StudentException e =  new StudentException();
				e.setMessage("Student allready approved!");
				throw e;
				
			}
			student.get().setIsApproved("1");
			studentRepository.save(student.get());
			isApprove = true;
		}
		/// admin repo nedd calll here 

		return isApprove;
	}
	/**
	 * 
	 * @return
	 */
	public List<Catalog> viewCourses() {
		 List<Catalog> list =  (List<Catalog>) catalogRepository.findAll();
		 return list;
	}


	/**
	 * 
	 * @param Studentid
	 */
	public void setGeneratedReportCardTrue(String Studentid) {
		// TODO Auto-generated method stub
		//adminRepository.setGeneratedReportCardTrue(Studentid);
		
	}
	/**
	 * 
	 * @param Studentid
	 * @return
	 */
	public List<RegisteredCourse> generateGradeCard(String Studentid) {
		return null;
		// TODO Auto-generated method stub
		//return adminRepository.generateGradeCard(Studentid);
	}
	/**
	 * 
	 * @param courseCode
	 */
	public void removeCourse(String courseCode) {
		catalogRepository.deleteById(courseCode);
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * @param course
	 * @param courseList
	 * @throws CourseExistsAlreadyException
	 */
	public boolean addCourse(Catalog course, List<Catalog> courseList) throws CourseExistsAlreadyException {
		boolean result = false ;
		try {
			
			if(!isValidAddCourse(course, courseList)) {
				System.out.println("courseCode: " + course.getCourseCode() + " already present");
				throw new CourseExistsAlreadyException(course.getCourseCode());
			}
			Catalog catalogCourse=new Catalog();
			catalogCourse.setCourseCode(course.getCourseCode());
			catalogCourse.setCourseName(course.getCourseName());
			catalogCourse.setDescription(course.getDescription());
			Catalog  cat = catalogRepository.save(catalogCourse);
			if(cat!=null) {
				result = true;	
			}
		}
		catch(CourseExistsAlreadyException e) {
			throw e;
		}
		return result;
		
	}
	/**
	 * 
	 * @param course
	 * @param courseList
	 * @return
	 */
	private boolean isValidAddCourse(Catalog course, List<Catalog> courseList) {
		for(Catalog addCourse : courseList) {
			if(addCourse.getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
				return false; 
			}
		}
		return true;
	}
	
	public List<Student> viewPendingAdmissions() throws StudentException{
		List<Student> list = studentRepository.findAll();
		
		list.forEach(stud->{
			
			System.out.println(stud);
		});
		list  =	list.stream().filter(stud->stud.getIsApproved().equals("0")).collect(Collectors.toList());
		return list;
		
	}

	
	

}
