package com.employee.service;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.employee.exceptions.NoIdFoundException;
import com.employee.model.Employee;

public class EmpService {
	
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	java.util.Scanner sc= new java.util.Scanner(System.in);

	public void add(Employee employee) {
//		try
//		{
//			for(Employee e : employeeList) {
//				if(employee.getId() == e.getId())
//				{
//					throw new IdExistsException();
//					
//				}
//				else
//				{
					employeeList.add(employee);
					System.out.println("Employee added successfully.");
//				}
//			}
//		}
//		catch(IdExistsException e)
//		{
//			e.displayMessage();
//		}
			
	}

	public void viewAll() {
		
		for(Employee e : employeeList)
		{
			
			System.out.println("ID: "+e.getId()+"|| Name: "+e.getName()+"|| Designation: "+e.getDes()+"|| Salary: "+e.getSal());
			
		}
		
	}

	public void update(int id,int ch) {
//		Employee echange = null;
//		System.out.println("Enter ID of the employee to be updated: ");
//		int id = sc.nextInt();
		try
		{
			for(Employee e : employeeList) {
				if(id == e.getId())
				{
					
					switch(ch) {
					case 1: System.out.println("Enter name:");
					String name = sc.next();
					e.setName(name);
					break;
					case 2: System.out.println("Enter designation:");
					String des = sc.next();
					e.setDes(des);
					break;
					case 3: System.out.println("Enter salary:");
					String sal = sc.next();
					e.setSal(sal);
					break;
					default: System.out.println("Ivalid choice");
					break;
					}
				}
				else
				{
					throw new NoIdFoundException();
				
				}
			}
		}
		catch(NoIdFoundException e)
		{
			e.displayMessage();
		}
	}
			
		
		
	

	public void delete(int id) {
		try {
			for(Employee e : employeeList) {
				if(id == e.getId())
				{
					employeeList.remove(e);
					break;
					
				}
				else
				{
					throw new NoIdFoundException();
				}
			}
			
		}
		catch(NoIdFoundException e)
		{
			e.displayMessage();
		}
		
		
		
		
	}

	public void view(int id) {
		try {
			for(Employee e : employeeList) {
				if(id == e.getId())
				{
					System.out.println("ID: "+e.getId()+" Name: "+e.getName()+" Designation: "+e.getDes()+" Salary: "+e.getSal());
					break;
					
				}
				else
				{
					throw new NoIdFoundException();
				}
			}
			
		}
		catch(NoIdFoundException e)
		{
			e.displayMessage();
		}
			
	}
				
	
	public void imported() {
		// TODO Auto-generated method stub
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"C:\\Users\\HimanshuRaj\\Desktop\\EmployeeInformation.txt"));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				String []tokens = line.split(",");
				Employee emp = new Employee(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3]);
				employeeList.add(emp);
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
	           FileWriter fw=new FileWriter("C:\\\\Users\\\\HimanshuRaj\\\\Desktop\\\\details.txt");  
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
