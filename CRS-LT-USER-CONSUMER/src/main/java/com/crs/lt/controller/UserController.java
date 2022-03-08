package com.crs.lt.controller;

import java.io.IOException;
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
import com.crs.lt.model.Student;


@RestController
public class UserController {

	@Autowired
 DiscoveryClass  discoveryClass;

	
/**
 * 
 * @param userId
 * @return
 * @throws RestClientException
 * @throws IOException
 */
	
	@RequestMapping(value = "/getName/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String>  getName(@PathVariable("userId") String userId)  throws RestClientException, IOException {
		System.out.println("Consumer : getName" +userId);
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8084/user/getName/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl+userId,HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		  
		System.out.println(response.getBody());
		return response;
	}
	

	@RequestMapping(value = "/getRole/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String>  getRole(@PathVariable("userId") String userId)  throws RestClientException, IOException {
		System.out.println("Consumer : getName" +userId);
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8084/user/getRole/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl+userId,HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		  
		System.out.println(response.getBody());
		return response;
	}
	
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?>  getAllUser()  throws RestClientException, IOException {
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8084/user/getAllUser/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=null;
		try{
		response=restTemplate.exchange(baseUrl,HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		  
		System.out.println(response.getBody());
		return response;
	}
	
	@RequestMapping(value = "/verifyCredentials/{userId}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?>  verifyCredentials(
			       @PathVariable(value = "userId") String userId,
			       @PathVariable(value = "password") String password)  throws RestClientException, IOException {
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8084/user/verifyCredentials/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=null;
		try{
		response=restTemplate.exchange(baseUrl + userId + "/" + password ,HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		  
		System.out.println(response.getBody());
		return response;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?>  login(
			@RequestParam(value = "userId") String userId,
			       @RequestParam(value = "password") String password)  throws RestClientException, IOException {
		//http://localhost:8084/login?userId=11&password=ria
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8084/login/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=null;
		try{
			
			String url = baseUrl +"?"+ "userId=" + userId + "&" + "password=" + password ;
			System.out.println(url);
		response=restTemplate.exchange(url,HttpMethod.POST, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		  
		System.out.println(response.getBody());
		return response;
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?>  updatePassword(
			@RequestParam(value = "userId") String userId,
			@RequestParam(value = "password") String  password ,
			@RequestParam(value = "newPassword") String newPassword)  throws RestClientException, IOException {
		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8084/user/updatePassword/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response=null;
		try{
			
			String url = baseUrl +"?"+ "userId=" + userId + "&" + "password=" + password + "&" + "newPassword=" + newPassword ;
			
			System.out.println(url);
		response=restTemplate.exchange(url,HttpMethod.PUT, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		  
		System.out.println(response.getBody());
		return response;
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<?>  register(@RequestBody Student student) throws RestClientException, IOException {
//		String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8084/register";
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<?> response=null;
//		try{
//			String url = baseUrl ;
//			System.out.println(url);
//		response=restTemplate.exchange(url,HttpMethod.POST, getHeaders(),String.class);
//		}catch (Exception ex)
//		{
//			System.out.println(ex);
//		}
//		  
//		System.out.println(response.getBody());
//		return response;
//	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)

	public ResponseEntity<String> addStudent(@RequestBody Map<String, Object> studentMap)

	throws RestClientException, IOException {

	return discoveryClass.discoveryResult("user-producer", "/register", HttpMethod.POST, studentMap);
	}


	
	
	
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}

	
	


