package com.examples.spring;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.examples.spring.dao.EmployeeDao;
import com.examples.spring.service.EmployeeService;




@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.examples")
public class CustomDispatcherConfig {
	
	@Bean
	public EmployeeService empService() {
		return new EmployeeService();
	}
	
	@Bean
	public EmployeeDao empDao() {
//		return new EmployeeDaoJdbcImpl();
		return new EmployeeDao();
	}
	@Bean
	public Connection connection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "training", "training");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
