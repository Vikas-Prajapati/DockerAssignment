package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeRepository repository;

    @Autowired
    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository repository) {
        this.environment = environment;
        this.repository = repository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchange(@PathVariable("from") String from,
                                             @PathVariable("to") String to){
        Optional<CurrencyExchange> optionalCurrencyExchange = repository.findByFromAndTo(from , to);
        if(optionalCurrencyExchange.isEmpty())
            throw new RuntimeException("Unable to Find data for " + from +"to :" +to);
        String port = environment.getProperty("local.server.port");
        CurrencyExchange currencyExchange = optionalCurrencyExchange.get();
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
