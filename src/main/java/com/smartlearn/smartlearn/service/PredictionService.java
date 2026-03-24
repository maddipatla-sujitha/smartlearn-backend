package com.smartlearn.smartlearn.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.smartlearn.smartlearn.dto.PredictionRequest;

@Service
public class PredictionService {

    public String getPrediction(PredictionRequest request) {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Integer> body = new HashMap<>();
        body.put("attendance", request.getAttendance());
        body.put("quiz", request.getQuiz());
        body.put("assignment", request.getAssignment());

        String response = restTemplate.postForObject(
        		"https://smartlearn-ml.onrender.com/predict",
                body,
                String.class
        );

        return response;
    }
}