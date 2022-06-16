package com.ihub.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import com.ihub.dto.RoomDTO;
import com.ihub.service.CustomerService;
import com.ihub.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	RoomService roomService;

	Log logger = LogFactory.getLog(this.getClass());

	@PostMapping("/roompost")
	public void postroommapping(@RequestBody RoomDTO roomDTO) {

		logger.info("posting room details to DB" + roomDTO);
		roomService.postroommapping(roomDTO);

	}

	@GetMapping("/getroom/{rid}")
	public RoomDTO getroommapping(@PathVariable("rid") Integer rid) {

		logger.info("getting room from the DB" + rid);
		return roomService.getroommapping(rid);

	}

	@DeleteMapping("/deleteroom/{rid}")
	public Boolean deletecustomermapping(@PathVariable("rid") Integer rid) {
		
		logger.info("Delete room" + rid);

		return roomService.deleteroommapping(rid);
	}

	@PutMapping("/updateroom/{rid}")
	public RoomDTO updateroom(@PathVariable("rid") Integer rid, @RequestBody RoomDTO roomDTO) {

		logger.info("update Room  Details" + rid + roomDTO);
		return roomService.updateroom(rid, roomDTO);

	}
}
