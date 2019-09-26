package com.assignment.spring.employee;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


//@Component("")
//@Lazy(true)
public class Employee {
    @Value("1")
	private int id;
    @Value("HIMANSHU")
	private String name;
	private Address address;
	//@Value("27-11-1996")
	private LocalDate joiningDate;
	private List<String> skills;
	@Value("true")
	private boolean isActive;
	
	public Employee(int id, String name, Address address, LocalDate joiningDate, List<String> list, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.joiningDate = joiningDate;
		this.skills = list;
		this.isActive = isActive;
	}
	public Employee(Address address) {
		this.address=address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public List getSkills() {
		return skills;
	}
	public void setSkills(List skills) {
		this.skills = skills;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
