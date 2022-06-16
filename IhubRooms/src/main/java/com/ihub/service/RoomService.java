package com.ihub.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.dto.RoomDTO;
import com.ihub.entity.Room;
import com.ihub.repository.RoomRepo;

@Service
public class RoomService {

	@Autowired
	RoomRepo roomRepo;
	Log logger = LogFactory.getLog(this.getClass());

//	post method
	public void postroommapping(RoomDTO roomDTO) {

		Room room = roomDTO.DTOtoEntityconversion();
		logger.info("Creating Room Details" + room);
		roomRepo.save(room);
	}

//	get method
	public RoomDTO getroommapping(Integer rid) {

		Room room = roomRepo.getById(rid);
		logger.info("Get the Room Details as per room number" + room);
		return RoomDTO.roomEntitytoDTO(room);
	}

// delete method	
	public Boolean deleteroommapping(Integer rid) {

		try {
			roomRepo.deleteById(rid);
			logger.info("Deleted room");
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	public RoomDTO updateroom(Integer rid, RoomDTO roomDTO) {

		Room entityroom = roomRepo.findById(rid).get();

		entityroom.setRent(roomDTO.getRent());
		entityroom.setNoofrooms(roomDTO.getNoofrooms());
		entityroom.setType(roomDTO.getType());
		logger.info("Update the room Details" + entityroom);
		roomRepo.save(entityroom);

		return roomDTO;
	}

}