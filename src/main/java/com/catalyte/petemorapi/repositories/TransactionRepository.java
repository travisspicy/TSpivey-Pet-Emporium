package com.catalyte.petemorapi.repositories;

import com.catalyte.petemorapi.models.Transaction;
import com.catalyte.petemorapi.models.Items;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    @Query("{'_id':?0}")
    Optional<Transaction> findById(String _id);
    @Query("{'date':?0}")
    List<Transaction> findByDate (String date);
    @Query("{'items':?0}")
    List<Items> findByItems (String items);
    @Query("{'total':?0}")
    List<Transaction> findByTotal (String total);

}
