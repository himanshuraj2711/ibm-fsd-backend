package com.employee.main;



import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.employee.model.Employee;
import com.employee.service.EmpService;

public class EmpMain {
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
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		EmpService emp = new EmpService();
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
					System.out.println("1.Name\n2.Designation\n3.Salary\nEnter choice to update:");
					int ch = scan.nextInt();
					emp.update(i2,ch);
					break;
			case 4: int i = idReturn();
					emp.view(i);
					break;
			case 5: int i1 = idReturn();
					emp.delete(i1);
					break;
			case 6: ExecutorService e= Executors.newFixedThreadPool(2);
					Future<Boolean> f=e.submit(new Callable<Boolean>() {
					public Boolean call() throws RuntimeException, IOException {
					System.out.print("Thread : "+Thread.currentThread().getName());
					emp.imported();
					return true;
				}
			});
					if(f.get())
					{
						e.shutdown();
					}
					else
					{
						System.out.println("Future is still running.");
					}
			
			break; 
			case 7 : ExecutorService e1= Executors.newFixedThreadPool(2);
					Future<Boolean> f1=e1.submit(new Callable<Boolean>() {
					public Boolean call() throws RuntimeException, IOException {
					System.out.print("Thread : "+Thread.currentThread().getName());
					emp.exported();
					return true;
				}
			}); 
					if(f1.get())
					{
						e1.shutdown();
					}
					else
					{
						System.out.println("Future is still running.");
					}
					
					break;
			case 8: System.exit(0);
					break;
			default: System.out.println("Invalid choice.");
					break;
			
			}
			
			
		}

	}

}