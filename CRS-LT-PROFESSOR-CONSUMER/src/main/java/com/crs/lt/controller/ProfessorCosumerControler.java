package com.crs.lt.controller;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.crs.lt.component.DiscoveryClass;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@RestController
public class ProfessorCosumerControler
{
@Autowired
DiscoveryClass discoveryClass;

/**
*
* @param studentID
* @param courseID
* @param grade
* @return
*/
@RequestMapping(value = "/addGrade", method = RequestMethod.POST)
@ResponseBody
public ResponseEntity<?> addGrade(@RequestParam(value ="studentID") String studentID,
@RequestParam(value ="courseID") String courseID, @RequestParam(value ="grade") String grade) throws RestClientException, IOException{

String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8085/addGrade?";

RestTemplate restTemplate = new RestTemplate();

ResponseEntity<String> response=null;
try{
	String url = baseUrl + "studentID=" + studentID +"&" + "courseID=" + courseID + "&" + "grade=" + grade;
			System.out.println(url);
response = restTemplate.exchange(url ,  HttpMethod.POST, getHeaders(),String.class);
}catch (Exception ex)
{
System.out.println(ex);
}

System.out.println(response.getBody());
return response;
}



/**
*
* @param profId
* @return
*/
@RequestMapping(value = "/getProfessorById", method = RequestMethod.GET)
@ResponseBody
public ResponseEntity<?> getProfessorById(@RequestParam("profId") String profId) throws RestClientException, IOException{

String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8085/getProfessorById?";

RestTemplate restTemplate = new RestTemplate();

ResponseEntity<String> response=null;
try{
response = restTemplate.exchange(baseUrl + "profId=" + profId,HttpMethod.GET, getHeaders(),String.class);
}catch (Exception ex)
{
System.out.println(ex);
}

System.out.println(response.getBody());
return response;
}
/**
*
* @param profId
* @return
*/
@RequestMapping(value = "/viewEnrolledStudents/{profId}", method = RequestMethod.GET)
@ResponseBody
public ResponseEntity<?> viewEnrolledStudents(@PathVariable("profId") String profId) throws RestClientException, IOException
{
String baseUrl = "http://javafulstack-59.alchemycloud.co.in:8085/viewEnrolledStudents/";

RestTemplate restTemplate = new RestTemplate();

ResponseEntity<?> response=null;
try{
response = restTemplate.exchange(baseUrl+profId,HttpMethod.GET, getHeaders(),List.class);
}catch (Exception ex)
{
System.out.println(ex);
}

System.out.println(response.getBody());
return response;

}

private static HttpEntity<?> getHeaders() throws IOException {
HttpHeaders headers = new HttpHeaders();
headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
return new HttpEntity<>(headers);
}



}