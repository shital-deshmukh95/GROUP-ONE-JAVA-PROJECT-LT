package com.lt.crs.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.lt.exceptions.CourseNotFoundException;
import com.crs.lt.exceptions.StudentException;
import com.lt.crs.model.Course;
import com.lt.crs.model.PaymentInfo;
import com.lt.crs.model.RegisterCourseModelClass;
import com.lt.crs.model.RegisteredCourse;
import com.lt.crs.model.Student;
import com.lt.crs.repository.CourseRepository;
import com.lt.crs.repository.RegisteredCourseRepository;
import com.lt.crs.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private RegisteredCourseRepository registeredCourseRepository;


	@Autowired
	private RegisteredCourseService registeredCourseService;
	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws StudentException
	 */
	
	
	public boolean isApproved(String studentId) throws StudentException {
		boolean isApproved = false;
		Optional<Student> student = studentRepository.findById(studentId);

		if(student.isPresent()) {
			if("1".equalsIgnoreCase(student.get().getIsApproved())) {
				isApproved = true;
			}

		}

		if(!student.isPresent()) {
			StudentException e = new StudentException();
			e.setMessage("Student Not Found with the studentID" + studentId);
			throw  e;

		}


		return isApproved;
	}

	/**
	 * 
	 * @param student
	 * @return
	 */
	public String register(Student student) {
		Student newstudent = studentRepository.save(student);
		return newstudent.getStudentId();

	}

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public List<Course> viewCourses(String studentId) {

		System.out.println("viewCourses");
		List<Course>  list = new ArrayList<Course>();
		list = courseRepository.viewCourse(studentId);
		return list;
	}

	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws StudentException
	 */
	@Transactional
	public boolean dropCourse(String courseCode, String studentId) throws StudentException {
		Optional<Student> student = studentRepository.findById(studentId);

		if(student.isPresent()) {
			if("0".equalsIgnoreCase(student.get().getIsApproved())) {
				StudentException e = new StudentException();
				e.setMessage("Student course registration is pending");
				throw  e;
			}
		}

		RegisteredCourse registerCoursedelete=new RegisteredCourse();
//		//Optional<RegisteredCourse> r=registeredCourseRepository.findById(studentId);
//		System.out.println("coursecode"+r.get().getCourseCode());
//		System.out.println("studentid"+r.get().getStudentId());
//		registerCoursedelete.setCourseCode(r.get().getCourseCode());
//		registerCoursedelete.setStudentId(r.get().getStudentId());
//		registerCoursedelete.setGrade(r.get().getGrade());
		Optional<Course> c=courseRepository.findById(courseCode);
		if(c.isPresent()) {
			Course course=c.get();
			course.setAvailableSeats(c.get().getAvailableSeats()+1);
			courseRepository.save(course);
		}
		
		int a = registeredCourseRepository.deleteByCourseCodeAndStudentId(courseCode,studentId);
		System.out.println("delete"+a);

		return true;
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws StudentException
	 */
	public List<Course> viewRegisteredCourses(String studentId) throws StudentException {
		return registeredCourseRepository.viewRegisteredCourses(studentId);
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws StudentException
	 */
	public PaymentInfo makePayment(String studentId)throws StudentException  {
		PaymentInfo paymentInfo =  new PaymentInfo();
		double fee = 0;
		boolean isRegistered = false;
		boolean isPaid = false;
		isRegistered = registeredCourseService.getRegistrationStatus(studentId);
		isPaid = this.getPaymentStatus(studentId);

		if (!isRegistered) {
			StudentException e = new StudentException();
			e.setMessage("You havent registered for the course");
			System.out.println("You have not registered yet");
			throw  e;
		}

		if (isRegistered && !isPaid) {

			fee = this.calculateFee(studentId);
			paymentInfo.setStudentId(studentId);
			paymentInfo.setTotalfee(fee);
			System.out.println("Your total fee  = " + fee);
			System.out.println("Payment Successful by StudentId :" + studentId);
			boolean paymentStatus = this.setPaymentStatus(studentId);
			return paymentInfo;

		}

		return paymentInfo;
	}
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	private boolean setPaymentStatus(String studentId) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		if(studentOptional.isPresent()) {
			Student student =	studentOptional.get();
			student.setIsPaid("1");
			studentRepository.save(student);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	private double calculateFee(String studentId) {
		return  registeredCourseRepository.calulateFee(studentId);
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	private boolean getPaymentStatus(String studentId) {

		boolean paymentStatus = false;
		Optional<Student> student = studentRepository.findById(studentId);

		if(student.isPresent()) {
			if("1".equalsIgnoreCase(student.get().getIsPaid())) {
				paymentStatus = true;
			}

		}

		return paymentStatus;
	}

	/**
	 * 
	 * @param courseList
	 * @param studentId
	 * @return
	 * @throws StudentException
	 * @throws CourseNotFoundException
	 */
	public boolean regisetCourses(RegisterCourseModelClass courseList, String studentId) throws StudentException, CourseNotFoundException {
			List<Course> availableCourseList = courseRepository.viewCourse(studentId);
			Set<String> hash_set = new HashSet<String>();

			for (String courseCode : courseList.getCourseList()) {
				this.isCourseValid(courseCode, availableCourseList);

				if (!hash_set.add(courseCode)) {
					StudentException e = new StudentException();
					e.setMessage("Duplicate value  :" + courseCode);
					throw  e;
				}

			}

		//	List<Course> registeredCourseList = this.viewRegisteredCourses(studentId);

			for (String courseCode : courseList.getCourseList()) {
				System.out.println(courseCode);
				RegisteredCourse registeredCourse=new RegisteredCourse();
				if(registeredCourseService.addCourse(courseCode, studentId,registeredCourse)) {
					System.out.println("if****************");
			     registeredCourseService.setRegistrationStatus(studentId);
			     }
			    }
			return true;
		}

	/**
	 * 
	 * @param courseCode
	 * @param availableCourseList
	 * @return
	 */
		public boolean isCourseValid (String courseCode,List<Course>availableCourseList){
			return availableCourseList.stream().anyMatch(c -> c.getCourseCode().equalsIgnoreCase(courseCode));
		}

	}
