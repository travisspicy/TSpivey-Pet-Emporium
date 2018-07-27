package com.catalyte.petemorapi.services;

import com.catalyte.petemorapi.authorization.Roles;
import com.catalyte.petemorapi.models.Customer;
import com.catalyte.petemorapi.repositories.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends PetStoreService implements iCustomerService{
    @Autowired
    private CustomerRespository customerRespository;

    public List<Customer> findAll(){return customerRespository.findAll();}

    public boolean create (String employeeId, Customer customer){
        if(authorized(employeeId, Roles.admin)){
            customerRespository.insert(customer);
            return true;
        } else return false;
    }

    public boolean update(String employeeId, Customer customer){
        if (authorized(employeeId, Roles.admin)){
            customerRespository.save(customer);
            return true;
        } else return false;
    }

    public boolean delete(String employeeId, String _id){
        if (authorized(employeeId, Roles.admin)){
            customerRespository.deleteById(_id);
            return true;
        } else return false;
    }
}
