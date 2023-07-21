package com.example.robot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.robot.model.Robot;

@CrossOrigin("*")
@RestController
public class DemoController {

	
	
	@GetMapping("/task/{weight}/{walked}")
    public ResponseEntity<String> performTask(@PathVariable int weight , @PathVariable int walked) {
       

		Robot robot=new Robot();

        if (weight > 15) {
            return ResponseEntity.ok("Overweight");
        }

        int powerConsumption = (int) (weight * 0.03);
        int remainingBattery = robot.getBatteryLevel() - powerConsumption;

        if (remainingBattery < 0) {
            return ResponseEntity.ok("Insufficient Battery");
        }

        robot.setBatteryLevel(remainingBattery);

        return ResponseEntity.ok("Task successfully Done.");
    }
}
