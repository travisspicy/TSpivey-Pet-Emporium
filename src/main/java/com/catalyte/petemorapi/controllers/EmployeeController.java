package com.catalyte.petemorapi.controllers;


import com.catalyte.petemorapi.models.Employee;
import com.catalyte.petemorapi.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Api (value= "Employee Controller for PetAPI" , produces = "Provides endpoints for the employee controller")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    public EmployeeController(){this(new EmployeeService());}
    public EmployeeController(EmployeeService employeeService){this.employeeService = employeeService;}

    @ApiOperation("Pulls up the employee database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", responseContainer = "List", response = Employee.class)})
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Employee> findAll(){return employeeService.findAll();}

}
