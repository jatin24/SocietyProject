package com.society.employee;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import com.society.employee.controller.implementation.EmployeeController;
import com.society.employee.pojo.Employee;
import com.society.employee.pojo.ResponseMessage;

@SpringBootTest
public class EmployeeControllerTest {

	@Test
	public void getEmployees() {
		EmployeeController controller = new EmployeeController();
		ResponseEntity<List<Employee>> response = controller.getEmployees();
		Assert.hasText("OK", response.getStatusCode().toString());

	}

	@Test
	public void saveEmployees() {
		EmployeeController controller = new EmployeeController();
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("jatin");
		emp.setDesignation("software engineer");
		ResponseEntity<ResponseMessage> response = controller.addEmployee(emp);
		ResponseMessage obj = (ResponseMessage) response.getBody();
		Assert.hasText("Saved Successfully", obj.message);
	}

	@Test
	public void updateEmployees() {
		EmployeeController controller = new EmployeeController();
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("jatin");
		emp.setDesignation("software engineer");
		controller.addEmployee(emp);
		ResponseEntity<ResponseMessage> response = controller.updateEmployee(emp, 1);
		Assert.hasText("OK", response.getStatusCode().toString());
	}

	@Test
	public void deleteEmployees() {
		EmployeeController controller = new EmployeeController();
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("jatin");
		emp.setDesignation("software engineer");
		controller.addEmployee(emp);
		ResponseEntity<ResponseMessage> response = controller.deleteEmployee(1);
		Assert.hasText("OK", response.getStatusCode().toString());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getEmployeeById() {
		EmployeeController controller = new EmployeeController();
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("jatin");
		emp.setDesignation("software engineer");
		controller.addEmployee(emp);
		ResponseEntity<Employee> response = controller.getEmployeeById(1);
		Assert.notNull(response.getBody());
	}

	@Test
	public void updateEmployees1() {
		EmployeeController controller = new EmployeeController();
		controller.getEmployeeList().clear();
		ResponseEntity<ResponseMessage> response = controller.updateEmployee(new Employee(), 1);
		Assert.hasText("Not found", response.getBody().toString());
	}

	@Test
	public void deleteEmployees1() {
		EmployeeController controller = new EmployeeController();
		controller.getEmployeeList().clear();
		ResponseEntity<ResponseMessage> response = controller.deleteEmployee(1);
		Assert.hasText("Not found", response.getBody().toString());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getEmployeeById1() {
		EmployeeController controller = new EmployeeController();
		controller.getEmployeeList().clear();
		ResponseEntity<Employee> response = controller.getEmployeeById(1);
		Assert.isNull(response.getBody());
	}
}
