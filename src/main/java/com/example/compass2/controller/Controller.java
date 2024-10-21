package com.example.compass2.controller;

import com.example.compass2.logic.DegreesRange;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    private Map<String, DegreesRange> compass = new HashMap<>();

    @PostMapping(value = "/createCom", consumes = "application/json", produces = "application/json")
    public void createCompass(@RequestBody Map<String, Object> direction) {
        String side = (String) direction.get("side");
        int startDegrees = (int) direction.get("startDegrees");
        int endDegrees = (int) direction.get("endDegrees");
        DegreesRange degrees = new DegreesRange(startDegrees, endDegrees);
        compass.put(side, degrees);
    }

    @GetMapping(value = "/getSide", consumes = "Application/json", produces = "Application/json")
    public String getSide(int degree) {
        for (Map.Entry<String, DegreesRange> entry : compass.entrySet()) {
            if (entry.getValue().contains(degree)) {
                return entry.getKey();
            }
        }return null;


    }

}
