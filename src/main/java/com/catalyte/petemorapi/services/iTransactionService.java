package com.catalyte.petemorapi.services;

import com.catalyte.petemorapi.models.Transaction;

import java.util.List;

public interface iTransactionService {
    List<Transaction> findAll();

    boolean create(String employeeId, Transaction transaction);

    boolean update(String employeeId, Transaction transaction);

    boolean delete (String employeeId, String _id);
}
