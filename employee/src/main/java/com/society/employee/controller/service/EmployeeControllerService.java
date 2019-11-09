package com.society.employee.controller.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.society.employee.pojo.Employee;
import com.society.employee.pojo.ResponseMessage;

public interface EmployeeControllerService {

	public ResponseEntity<List<Employee>> getEmployees();

	public ResponseEntity<ResponseMessage> addEmployee(@RequestBody Employee employee);

	ResponseEntity<ResponseMessage> updateEmployee(Employee emp, int id);

	ResponseEntity<ResponseMessage> deleteEmployee(int id);

	ResponseEntity<Employee> getEmployeeById(int id);
}