package com.ihub.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;


@Entity
public class Customer {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private String aid;
	@Column(nullable = false)
	private String cname;
	@Column(nullable = false)
	private String cadress;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String mobile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Room_Id")
	private Room room;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FoodId", referencedColumnName = "aid" )
	
	private List<Food> food;

	

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCadress() {
		return cadress;
	}

	public void setCadress(String cadress) {
		this.cadress = cadress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	


}
