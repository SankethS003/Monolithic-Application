package com.ihub.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.dto.CustomerDTO;
import com.ihub.dto.FoodDTO;
import com.ihub.dto.MappedDTO;
import com.ihub.dto.RoomDTO;
import com.ihub.entity.Customer;
import com.ihub.entity.Food;
import com.ihub.entity.Room;
import com.ihub.repository.CustRepo;

@Service
public class MainService {

	@Autowired
	CustRepo custRepo;
	Log logger = LogFactory.getLog(this.getClass());

//	 Mapped CRUd operations

	public String createcustomer(CustomerDTO customerDTO) {

		Customer cust = customerDTO.DTOtoEntityconversion();
		Room room = new Room();
		room.setRid(customerDTO.getRoomDTO().getRid());
		room.setRent(customerDTO.getRoomDTO().getRent());
		room.setType(customerDTO.getRoomDTO().getType());
		room.setNoofrooms(customerDTO.getRoomDTO().getNoofrooms());
		logger.info("Creating all Customer Details" + room);
		cust.setRoom(room);
		List<Food> foodlist = new ArrayList<Food>();

		foodlist = FoodDTO.DtotoEntity(customerDTO.getFoodDTO());
		logger.info("ordering the food for customer" + foodlist);
		cust.setFood(foodlist);

		custRepo.save(cust);

		return cust.getAid();
	}

	public List<CustomerDTO> getallmappedlist() {

		List<Customer> centity = custRepo.findAll();
		logger.info("Get all the customer and food list" + centity);
		return MappedDTO.EntitytoDTO(centity);
	}

	public Boolean deletecustomer(String aid) {

		try {
			custRepo.deleteById(aid);
			logger.info("deleted customer details");
			return true;

		} catch (Exception e) {

			return false;
		}

	}

	public CustomerDTO updatecustomer(String aid, CustomerDTO customerDTO) {

		Customer customer = custRepo.findById(aid).get();

		customer.setAge(customerDTO.getAge());
		customer.setCadress(customerDTO.getCadress());
		customer.setCname(customerDTO.getCname());
		customer.setMobile(customerDTO.getMobile());
		logger.info("Update customer Details" + customer);

		Room room = new Room();

		room.setRid(customerDTO.getRoomDTO().getRid());
		room.setType(customerDTO.getRoomDTO().getType());
		room.setNoofrooms(customerDTO.getRoomDTO().getNoofrooms());
		room.setRent(customerDTO.getRoomDTO().getRent());
		logger.info("Update customers Room Details" + room);
		customer.setRoom(room);

		List<Food> food = new ArrayList<Food>();

		food = FoodDTO.DtotoEntity(customerDTO.getFoodDTO());
		logger.info("update customers Food Order" + food);
		customer.setFood(food);

		custRepo.save(customer);
		return customerDTO;

	}

}
