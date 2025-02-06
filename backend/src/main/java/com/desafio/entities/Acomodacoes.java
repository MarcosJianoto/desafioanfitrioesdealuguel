package com.desafio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "acomodacoes")
public class Acomodacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acomodacoes_sequence")
	@SequenceGenerator(name = "acomodacoes_sequence", sequenceName = "acomodacoes_sequence", allocationSize = 1)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;

	@Column(name = "price_night")
	private Integer priceNight;

	@Column(name = "state")
	private String state;

	@Column(name = "city")
	private String city;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getPriceNight() {
		return priceNight;
	}

	public void setPriceNight(Integer priceNight) {
		this.priceNight = priceNight;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
