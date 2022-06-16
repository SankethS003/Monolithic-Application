package com.ihub.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihub.dto.CustomerDTO;

import com.ihub.service.MainService;

@RestController
@RequestMapping("/main")
public class MainController {

	@Autowired
	MainService mainService;
	Log logger = LogFactory.getLog(this.getClass());

// Mapped CRUD operations

	@PostMapping("/post")
	public ResponseEntity<String> createcustomer(@RequestBody CustomerDTO customerDTO) {
		logger.info("create customer, Room and Food in DB" + customerDTO);
		String result = mainService.createcustomer(customerDTO);
		return ResponseEntity.ok(result);

	}

	@GetMapping("/all")
	public List<CustomerDTO> getallmappedlist() {
		logger.info("Get all details from the DB");
		return mainService.getallmappedlist();

	}

	@DeleteMapping("/{aid}")

	public Boolean deletecustomer(@PathVariable("aid") String aid) {

		logger.info("Delete details" + aid);

		return mainService.deletecustomer(aid);

	}

	@PutMapping("/{aid}")
	public CustomerDTO updatecustomer(@PathVariable("aid") String aid, @RequestBody CustomerDTO customerDTO) {

		logger.info("inside update customer" + aid + customerDTO);
		return mainService.updatecustomer(aid, customerDTO);

	}

}
