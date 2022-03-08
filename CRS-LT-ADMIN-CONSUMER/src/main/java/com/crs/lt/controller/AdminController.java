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

@RestController
public class AdminController {
	@Autowired
 DiscoveryClass  discoveryClass;

	/**
	 * 
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	
	
	@RequestMapping(value = "/viewCourses", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getCourses() throws RestClientException, IOException {
	String baseUrl = "http://localhost:8081/admin/viewCourses";
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<?> response = null;
	try {
	response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), List.class);
	} catch (Exception ex) {
	System.out.println(ex);
	}
	return response;
	}
	
	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> approveAdmissionRequest(@RequestParam(value = "studentId") String studentId) throws RestClientException, IOException {
	String baseUrl = "http://localhost:8081/admin/approve?";
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<?> response = null;
	try {
	response = restTemplate.exchange(baseUrl + "studentId=" + studentId, HttpMethod.POST, getHeaders(), String.class);
	} catch (Exception ex) {
	System.out.println(ex);
	}
	return response;
	}
	
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteCourse(@RequestParam( value = "courseCode") String courseCode) throws RestClientException, IOException {
	String baseUrl = "http://localhost:8081/deleteCourse?";
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<?> response = null;
	try {
	response = restTemplate.exchange(baseUrl + "courseCode=" + courseCode, HttpMethod.DELETE, getHeaders(), String.class);
	} catch (Exception ex) {
	System.out.println(ex);
	}
	return response;
	}
	
	
	
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)

	public ResponseEntity<String> addCourse(@RequestBody Map<String, Object> catalogMap)

	throws RestClientException, IOException {
System.out.println("Cosumer : addCourse");
	return discoveryClass.discoveryResult("admin-producer", "/admin/addCourse", HttpMethod.POST, catalogMap);
	}

	
	

	@RequestMapping(value = "/viewPendingAdmissions", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> viewPendingAdmissions() throws RestClientException, IOException {
	String baseUrl = "http://localhost:8081/viewPendingAdmissions";
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<?> response = null;
	try {
	response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), List.class);
	} catch (Exception ex) {
	System.out.println(ex);
	}
	return response;
	}
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	
	
}
