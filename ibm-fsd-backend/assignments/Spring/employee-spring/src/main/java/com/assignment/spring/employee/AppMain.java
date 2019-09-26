package com.assignment.spring.employee;

import java.awt.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);

		
		Employee obj = (Employee) context.getBean("employee");
		System.out.println("Employee " + obj);
		//System.out.println("Dependent Person: " + obj.getPerson());
		
		String street = obj.getAddress().getStreet();
		String city =obj.getAddress().getCity();
		String country = obj.getAddress().getCountry();
		int pin = obj.getAddress().getPincode();
		
		
		
		System.out.println("EMPID: " +obj.getId() + "\nNAme: " +obj.getName() + "\nAddress: " +street +" " +city +" " +country +" "+ pin + "\nSkills :"+obj.getSkills() +"\nDOJ: " +obj.getJoiningDate()+ "\nActive: " +obj.isActive());
		
		
	}

}
