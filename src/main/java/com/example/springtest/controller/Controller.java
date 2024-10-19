package com.example.springtest.controller;

import com.example.springtest.logic.Pet;
import com.example.springtest.logic.PetModel;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(0);

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "application/json")
    public String createPet(@RequestBody Pet pet) {
        petModel.add(pet, newId.getAndIncrement());
        if (newId.get() > 1 ) {
            return "Поздравляем! Вы создали животное!";
        } else {
            return "Поздравляем! Вы создали своё первое животное!";
        }
    }

    @GetMapping(value = "/getAll", produces = "Application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "Application/json", produces = "Application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.getFrontList(id.get("id"));
    }

    @PutMapping(value = "/putPet", consumes = "Application/json",produces = "Application/json")
    public String putPet(@RequestBody Pet pet) {
        petModel.add(pet, newId.getAndIncrement());
        return "Животное успешно изменено!";

    }
    @DeleteMapping(value = "/deletePet",consumes = "Application/json",produces = "Application/json")
    public String deletePet(@RequestBody Pet pet) {
        return "Животное успешно удалено";

    }
}
