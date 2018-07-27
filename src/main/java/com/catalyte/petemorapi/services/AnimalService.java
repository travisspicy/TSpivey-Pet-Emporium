package com.catalyte.petemorapi.services;

import com.catalyte.petemorapi.authorization.Roles;
import com.catalyte.petemorapi.models.Animal;
import com.catalyte.petemorapi.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService extends PetStoreService implements iAnimalService{
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> findAll() {return animalRepository.findAll();}

    public boolean create(String employeeId, Animal animal){
        if (authorized(employeeId, Roles.admin)){
            animalRepository.insert(animal);
            return true;
        } else return false;
    }

    public boolean update(String employeeId, Animal animal){
        if (authorized(employeeId, Roles.admin)){
            animalRepository.save(animal);
            return true;
        } else return false;
    }

    public boolean delete(String employeeId, String _id){
        if(authorized(employeeId, Roles.admin)){
            animalRepository.deleteById(_id);
            return true;
        } else return false;
    }

}

