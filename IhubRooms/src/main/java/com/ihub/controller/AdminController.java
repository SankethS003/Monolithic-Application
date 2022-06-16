package com.ihub.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihub.dto.AdminDTO;
import com.ihub.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	Log logger = LogFactory.getLog(this.getClass());

//	create admin
	@PostMapping("/adminpost")
	public void createadmin(@RequestBody AdminDTO adminDTO) {

		logger.info("creating admin details to DB" + adminDTO);
		adminService.createadmin(adminDTO);

	}

//	login
	@PostMapping("/adminlogin")
	public Boolean loginadmin(@RequestBody AdminDTO adminDTO) {

		logger.info("Logging to admin " + adminDTO);
		return adminService.loginadmin(adminDTO);
	}
}
