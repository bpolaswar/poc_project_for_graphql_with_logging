package com.graphql.example.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.example.model.Department;
import com.graphql.example.model.Employee;
import com.graphql.example.model.EmployeeInput;
import com.graphql.example.repository.EmployeeRepository;
import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private DepartmentService departmentService;

	public List<Employee> allEmployees() {
		return empRepo.findAll();

	}

	public Optional<Employee> getEmployeeById(Long id) {
		return empRepo.findById(id);
	}

	public Employee createEmp(EmployeeInput employeeInput) {
		Department department = departmentService.getDepartmentById(employeeInput.getDeptId()).get();
		Employee e = Employee.builder().fname(employeeInput.getFname()).lname(employeeInput.getLname())
				.salary(employeeInput.getSalary()).department(department).build();
		return empRepo.save(e);
	}

	public String deleteEmp(Long empId) {
		String success = null;
		try {
			Employee exiEmp = getEmployeeById(empId).get();
			empRepo.deleteById(empId);
			success = "Employee deleted successfully";
		} catch (Exception e) {
			success = "Employee not found";
		}
		return success;
	}

	public Employee updateEmp(EmployeeInput employeeInput) {
		Employee exiEmp = empRepo.findById(employeeInput.getEid()).get();
		if (null != exiEmp) {
			exiEmp.setFname(employeeInput.getFname());
			exiEmp.setLname(employeeInput.getLname());
			exiEmp.setSalary(employeeInput.getSalary());
			if (employeeInput.getDeptId() > 0) {
				Department department = departmentService.getDepartmentById(employeeInput.getDeptId()).get();
				exiEmp.setDepartment(department);
			}
			empRepo.save(exiEmp);
			return exiEmp;
		} else {
			exiEmp = null;
			return exiEmp;
		}
	}
	
	   public List<Employee> getEmployeesByIds(List<Long> employeeIds)
	    {
	        return empRepo.findAllById(employeeIds);
	    }

	    public Map<Long,List<Employee>> getEmployeesByDepartmentIds(Set<Long> departments)
	    {
	        Map<Long,List<Employee>>  employees = empRepo.findByDepartment_IdIn(departments)
	                .stream()
	                .collect(groupingBy(employee -> employee.getDepartment().getId()));
	        return employees;
	    }

}
