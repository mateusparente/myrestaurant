package br.com.mateusparente.meurestaurante.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="RESTAURANT")
public class Restaurant {

	@Id
	@Column(nullable = false, name="RESTAURANT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Restaurant name is required.")
	@Column(name="RESTAURANT_NAME", nullable = false)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "restaurant")
	private List<Rate> rates;
	
	@Column(name = "RESTAURANT_RATES_COUNT")
	private Long ratesCount = 0L;
	
	public Restaurant() {
	}

	public Restaurant(Long id) {
		this.id = id;
	}
	
	public void addRateCount(){
		this.ratesCount++;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public Long getRatesCount() {
		return ratesCount;
	}

	public void setRatesCount(Long ratesCount) {
		this.ratesCount = ratesCount;
	}
	
}