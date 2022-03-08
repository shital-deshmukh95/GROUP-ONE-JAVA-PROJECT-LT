/**
 * 
 */
package com.crs.lt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.crs.lt.component.DiscoveryClass;
import com.crs.lt.model.PaymentInfo;

/**
 * @author user215
 *
 */
@RestController
public class StudentController {

	@Autowired
	DiscoveryClass  discoveryClass; 
	
	@RequestMapping(method = RequestMethod.GET, value = "/courses")
	@ResponseBody
	public ResponseEntity<?> viewCourses(@RequestParam(value ="studentId") String studentId){
		System.out.println("Consumer : viewCourse" +studentId);
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8083/courses?";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=null;
		try {
			response=restTemplate.exchange(baseUrl+"studentId="+studentId,HttpMethod.GET, getHeaders(),List.class);

		}catch(Exception ex){
			System.out.println(ex);
		}
		//System.out.println(response.getBody());
		return response;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/dropCourse")
	@ResponseBody
	public ResponseEntity<Integer> dropCourse(
			@RequestParam(value = "courseCode") String courseCode,
			@RequestParam(value = "studentId") String studentId){

		System.out.println("Consumer : deletecourse" +studentId);
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8083/dropCourse?";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Integer> response=null;
		try {
			String url = baseUrl+ "courseCode=" + courseCode + "&"+ "studentId="+ studentId.toString();
			System.out.println(url);
			response=restTemplate.exchange(url, HttpMethod.DELETE, getHeaders(), Integer.class);

		}catch(Exception ex){
			System.out.println(ex);
		}
		//System.out.println(response.getBody());
		return response;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/viewRegisteredCourses")
	@ResponseBody
	public ResponseEntity<?>  viewRegisteredCourse(@RequestParam(value ="studentId") String studentId)  {
		System.out.println("Consumer : view Registered course" +studentId);
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8083/viewRegisteredCourses?";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=null;
		try {
			String url  = baseUrl + "studentId=" +studentId;
			response=restTemplate.exchange(url, HttpMethod.GET, getHeaders(),List.class);

		}catch(Exception ex){
			System.out.println(ex);
		} 
		return response;

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCourse")
	@ResponseBody
	public ResponseEntity<?> addCourse(@RequestParam(value = "courseCode") String courseCode,
			@RequestParam(value = "studentId", required = true) String studentId)
	{
		System.out.println("Consumer : addCourse" + studentId);
		
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8083/student/addCourse?";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=null;
		try {
			String url  = baseUrl + "courseCode=" + courseCode +"&"+ "studentId=" + studentId;
			
			
			System.out.println(url);
			response=restTemplate.exchange(url, HttpMethod.POST, getHeaders(),String.class);

		}catch(Exception ex){
			System.out.println(ex);
		} 
		return response;

	}

	
	//make_payment
	
	@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
	public ResponseEntity<?> makePayment(@RequestParam(value = "studentId") String studentId) 
	{
		System.out.println("Consumer : makePayment" + studentId);
		
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8083/make_payment?";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=null;
		try {
			String url  = baseUrl + "studentId=" + studentId;
			
			
			System.out.println(url);
			response=restTemplate.exchange(url, HttpMethod.POST, getHeaders(),PaymentInfo.class);

		}catch(Exception ex){
			System.out.println(ex);
		} 
		return response;

	}

	
	@RequestMapping(value = "/viewGradeCard/{studentId}", method = RequestMethod.GET)
	public ResponseEntity<?> viewGradeCard(@PathVariable(value = "studentId") String studentId) 
	{
		System.out.println("Consumer : viewGradeCard" + studentId);
		
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8083/viewGradeCard/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=null;
		try {
			String url  = baseUrl + studentId;
			
			
			System.out.println(url);
			response=restTemplate.exchange(url, HttpMethod.GET, getHeaders(),List.class);

		}catch(Exception ex){
			System.out.println(ex);
		} 
		return response;

	}

	
	
	
	
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//
//	public ResponseEntity<String> addStudent(@RequestBody Map<String, Object> studentMap)
//
//	throws RestClientException, IOException {
//
//	return discoveryClass.discoveryResult("user-producer", "/register", HttpMethod.POST, studentMap);
//	}



	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
