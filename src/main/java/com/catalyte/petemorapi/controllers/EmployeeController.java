package com.catalyte.petemorapi.controllers;


import com.catalyte.petemorapi.authorization.Roles;
import com.catalyte.petemorapi.exceptions.UserNotAdmin;
import com.catalyte.petemorapi.models.Employee;
import com.catalyte.petemorapi.services.EmployeeService;
import com.catalyte.petemorapi.services.iEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Api (value= "Employee Controller for PetAPI" , produces = "Provides endpoints for the employee controller")
public class EmployeeController {
    @Autowired
    private final iEmployeeService _employeeService;

    public EmployeeController(){this (new EmployeeService());}
    public EmployeeController(iEmployeeService employeeService){this._employeeService=employeeService;}

    @ApiOperation("Finds all the employees in the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", responseContainer = "List", response = Employee.class)})
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Employee> findAll(){return _employeeService.findAll();}

    @ApiOperation("Creates new employee user in the database")
    @ApiResponses(value = {@ApiResponse(code=200, message = "OK")})
    @RequestMapping(value = "/create/{employeeName}", method = RequestMethod.POST)
    public void create(@RequestBody Employee employee, @PathVariable String employeeId){
        if(!_employeeService.create(employeeId, employee))
            throw new UserNotAdmin();
    }

    @ApiOperation("Updates an employees record")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/update/{employeeId}", method = RequestMethod.PUT)
    public void update(@RequestBody Employee employee, @PathVariable String employeeId){
        if(!_employeeService.update(employeeId, employee))
            throw new UserNotAdmin();
    }

    @ApiOperation("Deletes an existing employee record")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.DELETE)
    public void delete(@RequestParam String firstName, @PathVariable String employeeId){
        if(!_employeeService.delete(firstName, employeeId))
            throw new UserNotAdmin();
    }
}
