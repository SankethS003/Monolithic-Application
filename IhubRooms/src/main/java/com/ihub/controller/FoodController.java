package com.ihub.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihub.dto.FoodDTO;
import com.ihub.service.FoodService;

import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping("/food")

public class FoodController {

	@Autowired
	FoodService foodService;

	Log logger = LogFactory.getLog(this.getClass());

	@PostMapping("/foodpost")
	public FoodDTO registerfood(@RequestBody FoodDTO foodDTO) {

		logger.info("registering the ordered food to DB" + foodDTO);
		return foodService.registerfood(foodDTO);
	}

	@GetMapping("/getfood/all")
	public List<FoodDTO> getallorderedfood() {

		logger.info("getting food from the DB");

		List<FoodDTO> foodDTO = foodService.getallorderedfood();

		return foodDTO;

	}

	@DeleteMapping("/deletefood/{fid}")
	public Boolean deletefoodmapping(@PathVariable("fid") Integer fid) {

		logger.info("Remove Food" + fid);
		return foodService.deletefoodmapping(fid);
	}

	@PutMapping("/updatefood/{fid}")
	public FoodDTO updatefoodmapping(@PathVariable("fid") Integer fid, @RequestBody FoodDTO foodDTO) {
		logger.info("update the food in DB" + fid + foodDTO);

		return foodService.updateroommapping(fid, foodDTO);

	}

}
