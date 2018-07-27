package com.catalyte.petemorapi.services;

import com.catalyte.petemorapi.models.Employee;
import com.catalyte.petemorapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class PetStoreService {
    @Autowired
    protected EmployeeRepository employeeRepository;

    protected boolean authorized(String employeeId, String role){
        List<Employee> employees = employeeRepository.findByEmployeeId(employeeId);
        Employee employee = employees.get(0);
        return employee != null && employee.getAdminRole().contains(role);
    }
}
