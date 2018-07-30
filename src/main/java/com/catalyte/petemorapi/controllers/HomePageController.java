package com.catalyte.petemorapi.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @ApiOperation("Basic welcome page, welcome to the website.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "", method=RequestMethod.GET)
    public String homepage(){return "Main Page";}

    @ApiOperation("Page contains user info about animals listed in the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/animals", method=RequestMethod.GET)
    public String animalPage(){return "Animal Page";}

    @ApiOperation("Displays basic customer information that they provided at checkout, as well as any relevant transaction history")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String customerPage(){return "Customer Page";}

    @ApiOperation("Displays the team members currently employed at the pet emporium")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employeePage(){return "Employee Page";}

    @ApiOperation("Displays all transactions processed by the store.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public String transactionPage() {return "Transactions Page";}
}
