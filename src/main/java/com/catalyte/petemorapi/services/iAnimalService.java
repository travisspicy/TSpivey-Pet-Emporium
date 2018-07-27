package com.catalyte.petemorapi.services;

import com.catalyte.petemorapi.models.Animal;

import java.util.List;

public interface iAnimalService {
    List<Animal> findAll();

    boolean create(String employeeId, Animal animal);

    boolean update(String employeeId, Animal animal);

    boolean delete(String employeeId, String _id);

}
