package com.smartlearn.smartlearn.controller;

import com.smartlearn.smartlearn.dto.PredictionRequest;
import com.smartlearn.smartlearn.service.RecommendationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PredictionController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("/predict")
    public Map<String, Object> predict(@RequestBody PredictionRequest req) {

        double avg = (req.getAttendance() + req.getQuiz() + req.getAssignment()) / 3.0;

        String grade;
        String feedback;

        if (avg >= 75) {
            grade = "A";
            feedback = "Excellent performance 🎉";
        } else if (avg >= 60) {
            grade = "B";
            feedback = "Good, but can improve 👍";
        } else {
            grade = "C";
            feedback = "Needs improvement ⚠️";
        }

        var recommendations =
                recommendationService.getRecommendations(req.getSubject(), (int) avg);

        return Map.of(
                "grade", grade,
                "average", avg,
                "feedback", feedback,
                "recommendations", recommendations
        );
    }
}