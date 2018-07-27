package com.catalyte.petemorapi.services;

import com.catalyte.petemorapi.models.Customer;

import java.util.List;

public interface iCustomerService {
    List<Customer> findAll();

    boolean create (String employeeId, Customer customer);

    boolean update (String employeeId, Customer customer);

    boolean delete (String employeeId, String _id);
}
