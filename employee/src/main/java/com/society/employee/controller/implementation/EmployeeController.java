package com.society.employee.controller.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.society.employee.controller.service.EmployeeControllerService;
import com.society.employee.controller.service.helpers.EmployeeHelper;
import com.society.employee.pojo.Employee;
import com.society.employee.pojo.ResponseMessage;

@Controller
public class EmployeeController implements EmployeeControllerService {

	static List<Employee> employeeList = new ArrayList<>();

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@Override
	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees() {
		Collections.sort(employeeList, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

	@Override
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseMessage> addEmployee(@RequestBody Employee employee) {
		try {
			employeeList.add(employee);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Saving failed"), HttpStatus.OK);
		}
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Saved Successfully"), HttpStatus.OK);
	}

	@Override
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<ResponseMessage> updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
		String status = EmployeeHelper.updateById(employeeList, id, emp);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(status), HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<ResponseMessage> deleteEmployee(@PathVariable int id) {
		String status = EmployeeHelper.deleteById(employeeList, id);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(status), HttpStatus.OK);
	}

	@Override
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee emp = EmployeeHelper.findById(employeeList, id);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
}