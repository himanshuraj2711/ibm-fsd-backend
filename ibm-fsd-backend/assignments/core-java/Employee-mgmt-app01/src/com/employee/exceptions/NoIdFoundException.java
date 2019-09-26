package com.employee.exceptions;

public class NoIdFoundException extends Exception {
	
	public NoIdFoundException()
	{}

	public void displayMessage() {
		System.out.println("Id doesn't exist. Please enter a valid one.");
	}
}