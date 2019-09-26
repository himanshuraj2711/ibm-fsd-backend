package com.examples.empapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

@WebServlet("/deleteEmployee.do")
public class DeleteEmployeesController extends HttpServlet {

		EmployeeService empService = new EmployeeService();
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Integer id = Integer.parseInt(req.getParameter("id"));
			
			
			empService.delete(id);
			
			System.out.println("Employee deleted successfully.");
			
			RequestDispatcher rd = req.getRequestDispatcher("listEmployees.do");
			rd.forward(req, resp);
			
			
		}
}
