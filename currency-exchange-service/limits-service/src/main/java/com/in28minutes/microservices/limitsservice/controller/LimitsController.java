package com.in28minutes.microservices.limitsservice.controller;

import com.in28minutes.microservices.limitsservice.config.LimitConfig;
import com.in28minutes.microservices.limitsservice.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final LimitConfig limitConfig;

    @Autowired
    public LimitsController(LimitConfig limitConfig) {
        this.limitConfig = limitConfig;
    }


    @GetMapping("/limits")
    public Limits retrieveLimits(){
        return new Limits(limitConfig.getMinimum(),limitConfig.getMaximum());
    }
}
