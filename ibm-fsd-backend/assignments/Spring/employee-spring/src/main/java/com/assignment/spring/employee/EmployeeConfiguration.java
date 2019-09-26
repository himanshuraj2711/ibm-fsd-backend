package com.assignment.spring.employee;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class EmployeeConfiguration {

	
	@Bean
  public Employee employee() {
      return new Employee(2,"Himanshu",address(),LocalDate.now(),Arrays.asList("JAVA","C++"),true);
  } 
//	
	@Bean
	public Address address() {
		return new Address("NagWara","BAngaluru","INDIA",790045);
		//return new Address();
	}
}
