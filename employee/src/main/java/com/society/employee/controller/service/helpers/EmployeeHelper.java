package com.society.employee.controller.service.helpers;

import java.util.List;

import com.society.employee.pojo.Employee;

public class EmployeeHelper {
	public static Employee findById(List<Employee> employeeList, int id) {
		if (employeeList == null || employeeList.size() == 0) {
			return null;
		}

		Employee employee = null;

		for (Employee emp : employeeList) {
			if (emp.getId() == id) {
				employee = emp;
				break;
			}
		}

		return employee;
	}

	public static String deleteById(List<Employee> employeeList, int id) {
		if (employeeList == null || employeeList.size() == 0) {
			return "Not found";
		}

		int pos = -1;
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(0).getId() == id) {
				pos = i;
				break;
			}
		}

		if (pos != -1) {
			employeeList.remove(pos);
			return "Deleted employee with id : " + id;
		}

		return "Not found";
	}

	public static String updateById(List<Employee> employeeList, int id, Employee emp) {
		if (employeeList == null || employeeList.size() == 0) {
			return "Not found";
		}

		int pos = -1;
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(0).getId() == id) {
				pos = i;
				break;
			}
		}

		if (pos != -1) {
			Employee employee = employeeList.get(pos);
			employee.setDesignation(emp.getDesignation());
			employee.setName(emp.getName());
			return "Employee information updated with id : " + id;
		}

		return "Not found";
	}
}
