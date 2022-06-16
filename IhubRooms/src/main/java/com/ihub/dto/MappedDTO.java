package com.ihub.dto;

import java.util.ArrayList;
import java.util.List;

import com.ihub.entity.Customer;

public class MappedDTO {


	public static List <CustomerDTO> EntitytoDTO(List<Customer> centity) {

		
		List<CustomerDTO> customerDTOlist = new ArrayList<CustomerDTO>();
		for(int i=0; i<centity.size(); i++)
		{
		CustomerDTO  customerDTO = MappedDTO.MappedEntitytoDTO(centity.get(i));
		customerDTOlist.add(customerDTO);
		}
		return customerDTOlist;
		
		

	}
		
//		entity to DTO conversion
		public static  CustomerDTO MappedEntitytoDTO(Customer centity) {

			
			CustomerDTO customerDTO = new CustomerDTO();
			
			customerDTO.setAid(centity.getAid());
			customerDTO.setAge(centity.getAge());
			customerDTO.setCadress(centity.getCadress());
			customerDTO.setCname(centity.getCname());
			customerDTO.setMobile(centity.getMobile());
			
			RoomDTO roomDTO = RoomDTO.roomEntitytoDTO(centity.getRoom());
			customerDTO.setRoomDTO(roomDTO);
			List<FoodDTO> foodDTO = FoodDTO.foodEntitytoDTO(centity.getFood());
			customerDTO.setFoodDTO(foodDTO);
			
			return customerDTO;
//			
		}



	
}
