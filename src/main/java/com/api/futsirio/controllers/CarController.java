package com.api.futsirio.controllers;

import com.api.futsirio.entities.Cars;
import com.api.futsirio.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Cars> findAll() {
        List<Cars> result = carRepository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Cars findById(@PathVariable Long id) {
        Cars result = carRepository.findById(id).get();
        return result;
    }

    @PostMapping
    public Cars insert(@RequestBody Cars cars) {
        Cars result = carRepository.save(cars);
        return result;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCars(@PathVariable(value = "id") Long id,
                                                @RequestBody Cars cars) {
        Optional<Cars> carOptional = carRepository.findById(id);
        if(!carOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player não encontrado");
        }
        var car = carOptional.get();
        car.setCarro(cars.getCarro());

        return ResponseEntity.status(HttpStatus.OK).body(carRepository.save(car));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePlayer(@PathVariable(value = "id") Long id) {
        Optional<Cars> carOptional = carRepository.findById(id);
        if(!carOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player não encontrado");
        }
        carRepository.delete(carOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Player deletado com sucesso");
    }

}








