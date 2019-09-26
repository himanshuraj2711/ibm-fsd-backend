package com.employee.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.employee.database.EmployeeDb;
import com.employee.model.Employee;

public class EmployeeService {
	
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	EmployeeDb db = new EmployeeDb();
	java.util.Scanner sc= new java.util.Scanner(System.in);

	public void add(Employee employee) throws SQLException {
		db.addEmployee(employee);
				
	}

	public void viewAll() throws SQLException {
		db.displayEmployee();
		
	}

	
	
	public void update(int id) throws SQLException {
		db.updateEmployee(id);
		
	}

	public void delete(int id) throws SQLException {
		
		db.deteleEmployee(id);
		
		
	}

	public void view(int id) throws SQLException {
		
			db.viewEmployee(id);
	}

	public void imported() throws SQLException {
		// TODO Auto-generated method stub
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"C:\\\\Users\\\\HimanshuRaj\\\\Desktop\\\\EmployeeInformation.txt"));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				String []tokens = line.split(",");
				Employee emp = new Employee(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3]);
				db.addEmployee(emp);
				line = reader.readLine();
			}
			reader.close();
			System.out.println("File imported successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exported() {
		 try{    
	           FileWriter fw=new FileWriter("C:\\\\\\\\Users\\\\\\\\HimanshuRaj\\\\\\\\Desktop\\\\\\\\details.txt"); 
	           ArrayList<Employee> employeeList= new ArrayList<Employee>();
	           employeeList = (ArrayList<Employee>) db.exportEmployees();
	           for(Employee e : employeeList)
	           {
	        	   fw.write(e.getId()+","+e.getName()+","+e.getDes()+","+e.getSal()+"\n"); 
	        	   
	           }
	              
	           fw.close();    
	          }
		 catch(Exception e){System.out.println(e);}    
	          System.out.println("File exported succesfully");    
		
	}

	

}