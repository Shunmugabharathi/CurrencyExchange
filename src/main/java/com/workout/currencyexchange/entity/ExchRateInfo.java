package com.workout.currencyexchange.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name ="CurrencyExchangeRate")
public class ExchRateInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String fromCurrency;
    private String toCurrency;
    private Double exchangeRate;

    public ExchRateInfo(String fromCurrency, String toCurrency, Double exchangeRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.exchangeRate = exchangeRate;
    }


}
