package com.catalyte.petemorapi.repositories;

import com.catalyte.petemorapi.models.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends MongoRepository <Animal, String>{
    @Query("{'name':?0}")
    List<Animal> findByName(String name);
    @Query("{'_id':?0}")
    Optional<Animal> findById (String _id);
    @Query("{'petType':?0}")
    List<Animal> findByType (String petType);
    @Query("{'sex':?0}")
    List<Animal> findBySex (String sex);
    @Query("{'color':?0}")
    List<Animal> findByColor (String color);
    @Query("{'age':?0}")
    List<Animal> findByAge (String age);

}
