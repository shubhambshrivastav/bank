package org.eylem.mybank.exchange;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;

@Data
@Builder
public class RestExchangeDto {
    private HashMap<String, Double> rates;
    private String base;
    private LocalDate date;
	public HashMap<String, Double> getRates() {
		return rates;
	}
	public void setRates(HashMap<String, Double> rates) {
		this.rates = rates;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
    
    

}
