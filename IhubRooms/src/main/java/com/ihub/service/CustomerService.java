package com.ihub.service;

import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.dto.CustomerDTO;
import com.ihub.entity.Customer;
import com.ihub.exceptionhandler.IhubException;
import com.ihub.repository.CustRepo;

@Service
public class CustomerService {

	@Autowired
	CustRepo custRepo;

	Log logger = LogFactory.getLog(this.getClass());
	
//	post method
	public void postcustomermapping(CustomerDTO customerDTO) throws IhubException  {

		try {
			Customer cust = customerDTO.DTOtoEntityconversion();
			custRepo.save(cust);
			logger.info("Customer Details posted" + cust);
		} catch (Exception e) {
			throw new IhubException();
		}
		
	}

//	get method
	public CustomerDTO getcustomermapping(String aid)  {
		
		try {
		
		Customer centity = custRepo.getById(aid);
		logger.info("Get all the customer details" + centity);
		return CustomerDTO.customerEntitytoDTO(centity);
		
		
		} catch (Exception e)  {

			throw new  NoSuchElementException();
			
		}
	}

// delete method	
	public Boolean deletecustomermapping(String aid) {

		try {
			custRepo.deleteById(aid);
			logger.info("Customer Details Deleted");
			return true;
		} catch (Exception e) {

			return false;
		}

	}
//	update method

	public CustomerDTO updatecustomermapping(String aid, CustomerDTO customerDTO) {

		Customer entitycust = custRepo.findById(aid).get();
	
		entitycust.setAge(customerDTO.getAge());
		entitycust.setCadress(customerDTO.getCadress());
		entitycust.setCname(customerDTO.getCname());
		entitycust.setMobile(customerDTO.getMobile());
		logger.info(entitycust);

		 custRepo.save(entitycust);

		return customerDTO;
	}

}
