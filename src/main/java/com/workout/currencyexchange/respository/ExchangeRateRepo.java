package com.workout.currencyexchange.respository;

import com.workout.currencyexchange.entity.ExchRateInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface ExchangeRateRepo extends JpaRepository<ExchRateInfo, Long> {

    ExchRateInfo findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);

}
