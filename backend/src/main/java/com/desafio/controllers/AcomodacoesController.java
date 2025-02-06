package com.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.dto.AcomodacoesDTO;
import com.desafio.services.AcomodacoesService;

@RestController
@CrossOrigin(origins = "*")
public class AcomodacoesController {

	@Autowired
	private AcomodacoesService acomodacoesService;

	@PostMapping("/save-acomodacoes")
	public ResponseEntity<Void> saveCategory(@RequestBody AcomodacoesDTO acomodacoesDTO) {

		acomodacoesService.saveAcomodacoesInBD(acomodacoesDTO);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/get-acomodacoes")
	public ResponseEntity<List<AcomodacoesDTO>> getAcomodacoes() {
		List<AcomodacoesDTO> acomodacoesDTOs = acomodacoesService.getAcomodacoes();
		return ResponseEntity.ok().body(acomodacoesDTOs);
	}

	@GetMapping("/get-acomodacoes/{id}")
	public ResponseEntity<AcomodacoesDTO> getCategoryForId(@PathVariable Long id) {
		AcomodacoesDTO acomodacao = acomodacoesService.getAcomodacoesById(id);
		return ResponseEntity.ok().body(acomodacao);
	}

	@GetMapping("/get-acomodacoes-for-city")
	public ResponseEntity<List<AcomodacoesDTO>> getAcomodacoesForCity(@RequestParam String city) {
		String normalizedCity = city.toLowerCase().trim();
		List<AcomodacoesDTO> acomodacoesDTOs = acomodacoesService.getAcomodacoesByCity(normalizedCity);
		return ResponseEntity.ok().body(acomodacoesDTOs);
	}

	@DeleteMapping("/delete-acomodacoes/{id}")
	public void deleteCategory(@PathVariable Long id) {
		acomodacoesService.deleteAcomodacoesInBdById(id);
	}

}
