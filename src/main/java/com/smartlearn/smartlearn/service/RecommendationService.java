package com.smartlearn.smartlearn.service;

import com.smartlearn.smartlearn.model.Course;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationService {

    public List<Course> getRecommendations(String subject, int score) {

        List<Course> list = new ArrayList<>();

        if (score < 50) {
            list.add(new Course("Basics of " + subject,
                    "https://youtube.com", "Beginner", subject));

            list.add(new Course(subject + " Crash Course",
                    "https://geeksforgeeks.org", "Beginner", subject));
        }

        else if (score < 75) {
            list.add(new Course("Intermediate " + subject,
                    "https://coursera.org", "Intermediate", subject));
        }

        else {
            list.add(new Course("Advanced " + subject,
                    "https://udemy.com", "Advanced", subject));
        }

        return list;
    }
}