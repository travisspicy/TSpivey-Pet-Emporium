package com.catalyte.petemorapi.controllers;

import com.catalyte.petemorapi.exceptions.UserNotAdmin;
import com.catalyte.petemorapi.models.Customer;
import com.catalyte.petemorapi.services.CustomerService;
import com.catalyte.petemorapi.services.iCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers")
@Api(value="Customer container api", produces = "Provides RESTful endpoints for customers")
public class CustomerController {
    @Autowired
    private final iCustomerService _customerservice;
    public CustomerController(){this(new CustomerService());}
    public CustomerController(iCustomerService customerService){this._customerservice = customerService;}

    @ApiOperation("Find all products in the databasse")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", responseContainer = "List", response = Customer.class)})
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Customer> findAll(){return _customerservice.findAll();}

    @ApiOperation("Creates a new customer record in the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/create/{employeeId}", method = RequestMethod.POST)
    public void create(@RequestBody Customer customer, @PathVariable String employeeId){
        if(!_customerservice.create(employeeId, customer))
            throw new UserNotAdmin();
    }

    @ApiOperation("Updates an existing Customer record in the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/update/{employeeId}", method = RequestMethod.PUT)
    public void update (@RequestBody Customer customer, @PathVariable String employeeId){
        if(!_customerservice.update(employeeId, customer))
            throw new UserNotAdmin();
    }

    @ApiOperation("Deletes an existing customer listing in the database")
    @ApiResponses(value = {@ApiResponse(code=200, message = "OK")})
    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.DELETE)
    public void delete(@RequestParam String customerId, @PathVariable String employeeId){
        if(!_customerservice.delete(employeeId, customerId))
            throw new UserNotAdmin();
    }
}
