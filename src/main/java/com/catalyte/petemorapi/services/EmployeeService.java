package com.catalyte.petemorapi.services;

import com.catalyte.petemorapi.authorization.Roles;
import com.catalyte.petemorapi.models.Employee;
import com.catalyte.petemorapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService extends PetStoreService implements iEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){return employeeRepository.findAll();}

    public boolean create(String employeeId, Employee employee){
        if(authorized(employeeId, Roles.admin)){
            employeeRepository.insert(employee);
            return true;
        }else return false;
    }

    public boolean update(String employeeId, Employee employee){
        if(authorized(employeeId, Roles.admin)){
            employeeRepository.save(employee);
            return true;
        } else return false;
    }

    public boolean delete(String employeeId, String _id){
        if(authorized(employeeId, Roles.admin)){
            employeeRepository.deleteById(_id);
            return true;
        }else return false;
    }
}
