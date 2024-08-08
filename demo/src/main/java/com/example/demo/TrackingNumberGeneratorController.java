package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TrackingNumberGeneratorController {

    @Autowired
    private TrackingNumberGeneratorService trackingNumberGeneratorService;

    @GetMapping("/tracking-number")
    public String generateTrackingNumber() {
        return trackingNumberGeneratorService.generateTrackingNumber();
    }
}
