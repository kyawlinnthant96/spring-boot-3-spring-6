package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define private field for dependency
    private Coach myCoach;
    private Coach myAnotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("baseballCoach") Coach theCoach,
            @Qualifier("baseballCoach") Coach theAnotherCoach
    ) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        myAnotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return ("Comparing bean: myCoach == myAnother ," + ( myCoach == myAnotherCoach));
    }

}
