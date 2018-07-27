package com.catalyte.petemorapi.repositories;

import com.catalyte.petemorapi.models.Address;
import com.catalyte.petemorapi.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRespository extends MongoRepository<Customer, String> {
    @Query("{'customerId':?0}")
    List<Customer> findByCustomerId (String customerId);
    @Query("{'firstName':?0}")
    List<Customer> findByFirstName (String firstName);
    @Query("{'lastName':?0}")
    List<Customer> findByLastName (String lastName);
    @Query("{'_id':?0}")
    Optional<Customer> findById (String _id);
    @Query("{'joinDate':?0}")
    List<Customer> findByJoinDate (String joinDate);
    @Query("{'address':?0}")
    List<Address> findByAddress (String address);

}
