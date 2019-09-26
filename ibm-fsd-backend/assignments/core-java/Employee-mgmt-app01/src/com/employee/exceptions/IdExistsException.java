package com.employee.exceptions;


public class IdExistsException extends Exception {
	
	public void displayMessage() {
		System.out.println("Id already exist. Please enter a new one.");
	}

}