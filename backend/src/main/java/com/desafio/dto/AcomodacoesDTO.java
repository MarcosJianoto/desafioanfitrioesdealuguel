package com.desafio.dto;

public class AcomodacoesDTO {

	private Long id;

	private String name;

	private String image;

	private Integer priceNight;

	private String state;

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
