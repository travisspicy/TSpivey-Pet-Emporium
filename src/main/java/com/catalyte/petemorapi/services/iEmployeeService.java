package com.catalyte.petemorapi.services;

import com.catalyte.petemorapi.models.Employee;

import java.util.List;

public interface iEmployeeService {
    List<Employee> findAll();

    boolean create(String employeeId, Employee employee);

    boolean update(String employeeId, Employee employee);

    boolean delete(String employeeId, String _id);


}
