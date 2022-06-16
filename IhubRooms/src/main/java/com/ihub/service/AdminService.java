package com.ihub.service;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.dto.AdminDTO;
import com.ihub.entity.Admin;
import com.ihub.repository.AdminRepo;

@Service
public class AdminService {

	@Autowired
	AdminRepo adminRepo;

	Log logger = LogFactory.getLog(this.getClass());
	
	public void createadmin(AdminDTO adminDTO) {

		Admin adm = AdminDTO.DTOtoEntityconversion(adminDTO);
		logger.info(adm);	
		adminRepo.save(adm);

	}

	public Boolean loginadmin(AdminDTO adminDTO) {

		Boolean flag = false;
		Optional<Admin> admin = adminRepo.findById(adminDTO.getAdminid());

		if (admin.isPresent() && admin.get() != null && admin.get().getAdminpswd().equals(adminDTO.getAdminpswd())) {
			flag = true;
			logger.info("Admin Logged in" + admin);
		}
		return flag;

	}

}
