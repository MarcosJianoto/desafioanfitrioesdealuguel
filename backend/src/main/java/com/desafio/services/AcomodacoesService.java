package com.desafio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.dto.AcomodacoesDTO;
import com.desafio.entities.Acomodacoes;
import com.desafio.repository.AcomodacoesRepository;

@Service
public class AcomodacoesService {

	@Autowired
	private AcomodacoesRepository acomodacoesRepository;

	public void saveAcomodacoesInBD(AcomodacoesDTO acomodacoesDTO) {

		Acomodacoes acomodacoes = new Acomodacoes();
		acomodacoes.setName(acomodacoesDTO.getName());
		acomodacoes.setImage(acomodacoesDTO.getImage());
		acomodacoes.setPriceNight(acomodacoesDTO.getPriceNight());
		acomodacoes.setState(acomodacoesDTO.getState());
		acomodacoes.setCity(acomodacoesDTO.getCity());

		acomodacoesRepository.save(acomodacoes);
	}

	public List<AcomodacoesDTO> getAcomodacoes() {

		List<Acomodacoes> acomodacoes = acomodacoesRepository.findAll();
		List<AcomodacoesDTO> acomodacoesDTOs = new ArrayList<>();

		if (!acomodacoes.isEmpty()) {

			for (Acomodacoes home : acomodacoes) {
				AcomodacoesDTO acomodacoesDTO = new AcomodacoesDTO();

				acomodacoesDTO.setId(home.getId());
				acomodacoesDTO.setImage(home.getImage());
				acomodacoesDTO.setName(home.getName());
				acomodacoesDTO.setPriceNight(home.getPriceNight());
				acomodacoesDTO.setState(home.getState());
				acomodacoesDTO.setCity(home.getCity());

				acomodacoesDTOs.add(acomodacoesDTO);
			}

		}

		return acomodacoesDTOs;
	}

	public AcomodacoesDTO getAcomodacoesById(Long id) {

		Acomodacoes acomodacoes = acomodacoesRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Acomodacao not found"));

		AcomodacoesDTO acomodacoesDTO = new AcomodacoesDTO();
		acomodacoesDTO.setId(acomodacoes.getId());
		acomodacoesDTO.setImage(acomodacoes.getImage());
		acomodacoesDTO.setName(acomodacoes.getName());
		acomodacoesDTO.setPriceNight(acomodacoes.getPriceNight());
		acomodacoesDTO.setState(acomodacoes.getState());
		acomodacoesDTO.setCity(acomodacoes.getCity());

		return acomodacoesDTO;
	}

	public List<AcomodacoesDTO> getAcomodacoesByCity(String city) {

		String normalizedCity = city.toLowerCase();

		List<Acomodacoes> acomodacoes = acomodacoesRepository.findByCityIgnoreCase(normalizedCity);
		List<AcomodacoesDTO> acomodacoesDTOs = new ArrayList<>();
		if (!acomodacoes.isEmpty()) {

			for (Acomodacoes home : acomodacoes) {
				AcomodacoesDTO acomodacoesDTO = new AcomodacoesDTO();
				acomodacoesDTO.setId(home.getId());
				acomodacoesDTO.setImage(home.getImage());
				acomodacoesDTO.setName(home.getName());
				acomodacoesDTO.setPriceNight(home.getPriceNight());
				acomodacoesDTO.setState(home.getState());
				acomodacoesDTO.setCity(home.getCity());

				acomodacoesDTOs.add(acomodacoesDTO);
			}

		}

		return acomodacoesDTOs;
	}

	public void updateAcomodacoesById(Long id, AcomodacoesDTO acomodacoesDTO) {

		Acomodacoes acomodacoes = acomodacoesRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Acomodacao not found"));

		acomodacoes.setName(acomodacoesDTO.getName());
		acomodacoes.setImage(acomodacoesDTO.getImage());
		acomodacoes.setPriceNight(acomodacoesDTO.getPriceNight());
		acomodacoes.setState(acomodacoesDTO.getState());
		acomodacoes.setCity(acomodacoesDTO.getCity());

		acomodacoesRepository.save(acomodacoes);
	}

	public void deleteAcomodacoesInBdById(Long id) {

		acomodacoesRepository.deleteById(id);
	}

}
