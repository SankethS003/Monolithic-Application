package com.ihub.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.dto.FoodDTO;
import com.ihub.entity.Food;
import com.ihub.repository.FoodRepo;

@Service
public class FoodService {

	@Autowired
	FoodRepo foodRepo;

	Log logger = LogFactory.getLog(this.getClass());

//	post method
	public FoodDTO registerfood(FoodDTO foodDTO) {

		Food food = FoodDTO.DTOtoEntityconversion(foodDTO);
		foodRepo.save(food);
		logger.info("Order the food Required" + food);
		return foodDTO;

	}

//	get all method

	public List<FoodDTO> getallorderedfood() {

		List<Food> food = foodRepo.findAll();
		logger.info("Get all the orders Delivered" + food);
		return FoodDTO.foodEntitytoDTO(food);
	}

// delete method

	public Boolean deletefoodmapping(Integer fid) {

		try {
			foodRepo.deleteById(fid);
			logger.info("Cancel the Order");
			return true;
		} catch (Exception e) {

			return false;
		}
	}

//	update method

	public FoodDTO updateroommapping(Integer fid, FoodDTO foodDTO) {

		Food food = foodRepo.getById(fid);

		food.setFcost(foodDTO.getFcost());
		food.setFtype(foodDTO.getFtype());
		logger.info("Change the ordere order" + food);
		foodRepo.save(food);
		return foodDTO;
	}

}
