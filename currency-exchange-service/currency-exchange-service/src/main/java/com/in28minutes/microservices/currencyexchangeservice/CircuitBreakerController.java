package com.in28minutes.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/sample-api")
    //@Retry(name = "sample-api" , fallbackMethod = "hardcodedResponse")
    //@CircuitBreaker(name = "sample-api" , fallbackMethod = "hardcodedResponse")
    //@RateLimiter(name="sample-api" ,fallbackMethod = "hardcodedResponse")
    @Bulkhead(name = "sample-api" , fallbackMethod = "hardcodedResponse")
    public String sampleAPI(){
        logger.info("Sample API call Received");
//        ResponseEntity<String> response = new RestTemplate().getForEntity("http:/localhost:8080/some-dummy-url" , String.class);
//        return response.getBody();

        return "Sample-api";
    }

    public String hardcodedResponse(Exception ex){
        return "hardCoded Response ";
    }
}
