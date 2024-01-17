package com.workout.currencyexchange.controller;

import com.workout.currencyexchange.entity.ExchRateInfo;
import com.workout.currencyexchange.respository.ExchangeRateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/CurrencyExchange")
public class CurrencyExchangeController
{

    @Autowired
    ExchRateInfo exchRateInfo;

    @Autowired
    ExchangeRateRepo exchangeRateRepo;


    @GetMapping("/getRate/{fromCurrency}/to/{toCurrency}")
  //  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ExchRateInfo> getCurrencyExchange(@PathVariable String fromCurrency, @PathVariable String toCurrency ){

        ExchRateInfo exchRateDetails = exchangeRateRepo.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
        return new ResponseEntity<>(exchRateDetails, HttpStatus.OK);
    }

    @PostMapping("/addRate")
    public ResponseEntity<ExchRateInfo> addCurrencyExchange(@RequestBody ExchRateInfo exchRateInfo){

        ExchRateInfo saved = exchangeRateRepo.save(exchRateInfo);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

//update call
    @PutMapping ("/updateRate")
    public ResponseEntity<ExchRateInfo> updateCurrencyExchange(){

        System.out.println("hi da");

        return new ResponseEntity<>(new ExchRateInfo("INR","USD",80.00), HttpStatus.OK);
    }

    //delete call
    @DeleteMapping("/removeRate")
    public ResponseEntity<String> removeCurrencyExchange(){

        System.out.println("hi da");

        return new ResponseEntity<>("Delete call success", HttpStatus.OK);
    }
}
