package com.catalyte.petemorapi.controllers;

import com.catalyte.petemorapi.exceptions.UserNotAdmin;
import com.catalyte.petemorapi.models.Transaction;
import com.catalyte.petemorapi.services.TransactionService;
import com.catalyte.petemorapi.services.iTransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@Api(value="Transation Controller API", produces = "Provides RESTful endpoint for Transactions")
public class TransactionController {
    @Autowired
    private final iTransactionService _transactionService;
    public TransactionController(){this(new TransactionService());}
    public TransactionController(iTransactionService transactionService){this._transactionService = transactionService;}

    @ApiOperation("Find all products in the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", responseContainer = "List", response = Transaction.class)})
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Transaction> findAll(){return _transactionService.findAll();}

    @ApiOperation("Creates a new transaction in the database")
    @ApiResponses(value ={@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/create/{employeeId}", method = RequestMethod.POST)
    public void create(@RequestBody Transaction transaction, @PathVariable String employeeId){
        if(!_transactionService.update(employeeId, transaction))
            throw new UserNotAdmin();
    }

    @ApiOperation("Deletes an existing Transaction record in the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.DELETE)
    public void delete (@RequestParam String _id, @PathVariable String employeeId){
        if(!_transactionService.delete(employeeId, _id))
            throw new UserNotAdmin();
    }
}
