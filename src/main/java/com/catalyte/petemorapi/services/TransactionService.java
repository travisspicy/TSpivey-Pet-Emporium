package com.catalyte.petemorapi.services;

import com.catalyte.petemorapi.authorization.Roles;
import com.catalyte.petemorapi.models.Transaction;
import com.catalyte.petemorapi.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends PetStoreService implements iTransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAll(){return transactionRepository.findAll();}

    public boolean create (String employeeId, Transaction transaction){
        if (authorized(employeeId, Roles.admin)){
            transactionRepository.insert(transaction);
            return true;
        }else return false;
    }

    public boolean update(String employeeId, Transaction transaction){
        if (authorized(employeeId, Roles.admin)){
            return true;
        }else return false;
    }

    public boolean delete(String employeeId, String _id){
        if (authorized(employeeId, Roles.admin)){
            transactionRepository.deleteById(_id);
            return true;
        }else return false;
    }
}
