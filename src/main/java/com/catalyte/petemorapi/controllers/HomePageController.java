package com.catalyte.petemorapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @RequestMapping(value = "", method=RequestMethod.GET)
    public String homepage(){return "Main Page";}

    @RequestMapping(value = "/animals", method=RequestMethod.GET)
    public String animalPage(){return "Animal Page";}

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String customerPage(){return "Customer Page";}

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employeePage(){return "Employee Page";}

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public String transactionPage() {return "Transactions Page";}
}
