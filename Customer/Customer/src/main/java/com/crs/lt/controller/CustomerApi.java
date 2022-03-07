package com.crs.lt.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crs.lt.model.Customer;


@RestController
@CrossOrigin
public class CustomerApi {


	@RequestMapping(value = "/customer", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public Customer firstPage() {

		Customer cust = new Customer();
		cust.setCustomerId("101");
		cust.setCustomerName("Shita");
		cust.setAddress("Pune");
		return cust;
		
	}
	
	
	
}
