package com.employee.main;

import java.sql.SQLException;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

public class EmployeeMain {
	static java.util.Scanner scan = new java.util.Scanner(System.in);

	public static Employee getDetails() {
		System.out.println("Enter id: ");
		int id = scan.nextInt();
		System.out.println("Enter name: ");
		String name= scan.next();
		System.out.println("Enter designation: ");
		String des = scan.next();
		System.out.println("Enter salary: ");
		String sal = scan.next();
		Employee employee = new Employee(id,name,des,sal);
		return employee;
		
	}
	
	
	
	public static int idReturn()
	{
		System.out.println("Enter ID of the employee: ");
		int id = scan.nextInt();
		return id;
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		EmployeeService emp = new EmployeeService();
		while(true)
		{
			System.out.println("1.Add Employee\n2.View employees\n3.Update employee\n4.View employee\n5.Delete employee\n6.Import\n7.Export\n8.Exit");
			System.out.println("Enter your choice:");
			
			int choice = scan .nextInt();
			
			switch(choice)
			{
			case 1: Employee employee = getDetails();
					emp.add(employee);
					break;
			case 2: emp.viewAll();
					break;
			case 3: int i2 = idReturn();
					emp.update(i2);
					break;
			case 4: int i = idReturn();
					emp.view(i);
					break;
			case 5: int i1 = idReturn();
					emp.delete(i1);
					break;
			case 6: emp.imported();
					break;
			case 7 : emp.exported();
					break;
			case 8: System.exit(0);
					break;
			default: System.out.println("Invalid choice.");
					break;
			
			}
			
			
		}

	}

}
