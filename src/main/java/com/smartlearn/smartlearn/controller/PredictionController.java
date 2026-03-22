package com.smartlearn.smartlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smartlearn.smartlearn.dto.PredictionRequest;
import com.smartlearn.smartlearn.service.PredictionService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping("/predict")
    public String predict(@RequestBody PredictionRequest request) {

        return predictionService.getPrediction(request);
    }
}