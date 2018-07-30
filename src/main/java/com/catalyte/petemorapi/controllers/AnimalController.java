package com.catalyte.petemorapi.controllers;

import com.catalyte.petemorapi.exceptions.UserNotAdmin;
import com.catalyte.petemorapi.models.Animal;
import com.catalyte.petemorapi.services.AnimalService;
import com.catalyte.petemorapi.services.iAnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
@Api(value = "Products Controller Api", produces = "Provides RESTful endpoint for Animals")
public class AnimalController {
    @Autowired
    private final iAnimalService _animalService;
    public AnimalController(){this (new AnimalService());}
    public AnimalController(iAnimalService animalService){this._animalService=animalService;}

    @ApiOperation("Finds all Animals in the database")
    @ApiResponses(value = {@ApiResponse(code= 200, message = "OK", responseContainer = "List", response = Animal.class)})
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Animal> findAll(){return _animalService.findAll();}

    @ApiOperation("Creates a new animal listing in the datbase")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/create/{employeeId}", method = RequestMethod.POST)
    public void create(@RequestBody Animal animal, @PathVariable String employeeId){
        if(!_animalService.create(employeeId, animal))
            throw new UserNotAdmin();
    }

    @ApiOperation("Updates an existing animal record")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @RequestMapping(value = "/update/{employeeId}", method = RequestMethod.PUT)
    public void update(@RequestBody Animal animal, @PathVariable String employeeId){
        if(!_animalService.update(employeeId, animal))
            throw new UserNotAdmin();
    }

    @ApiOperation("Deletes an animals record")
    @ApiResponses(value={@ApiResponse(code=200, message = "OK")})
    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.DELETE)
    public void delete(@RequestParam String animalName, @PathVariable String employeeId){
        if(!_animalService.delete(employeeId, animalName))
            throw new UserNotAdmin();
    }

}
