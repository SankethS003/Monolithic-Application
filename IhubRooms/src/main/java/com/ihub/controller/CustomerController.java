package com.ihub.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihub.dto.CustomerDTO;
import com.ihub.exceptionhandler.IhubException;
import com.ihub.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	Log logger = LogFactory.getLog(this.getClass());

	@PostMapping("/custpost")
	public void postcustomermapping(@RequestBody CustomerDTO customerDTO) throws IhubException {

		logger.info("posting customer details to DB" + customerDTO);
		customerService.postcustomermapping(customerDTO);

	}

	@GetMapping("/getcustomer/{aid}")
	public CustomerDTO getcustomermapping(@PathVariable("aid") String aid) {

		logger.info("getting customer from the DB" + aid);

		return customerService.getcustomermapping(aid);

	}

	@DeleteMapping("/deletecustomer/{aid}")
	public Boolean deletecustomermapping(@PathVariable("aid") String aid) {

		logger.info("Delete customer" + aid);

		return customerService.deletecustomermapping(aid);
	}

	@PutMapping("/updatecustomer/{aid}")
	public CustomerDTO updatecustomermapping(@PathVariable("aid") String aid, @RequestBody CustomerDTO customerDTO) {
		logger.info("customer details has been Updated" + aid + customerDTO);
		return customerService.updatecustomermapping(aid, customerDTO);

	}

}
