package com.example.desafio_v2.controller;

import java.util.List;
import java.util.stream.Collectors;



import com.example.desafio_v2.domain.dto.response.CategoriaEventoResponse;
import com.example.desafio_v2.domain.mapper.CategoriaEventoMapper;
import com.example.desafio_v2.service.CategoriaEventoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categoriaevento")
public class CategoriaEventoController {

	private final CategoriaEventoService categoriaEventoService;
	private final CategoriaEventoMapper mapper;

	@Autowired
	public CategoriaEventoController(CategoriaEventoService categoriaEventoService, CategoriaEventoMapper categoriaEventoMapper) {
		this.categoriaEventoService = categoriaEventoService;
		this.mapper = categoriaEventoMapper;
	}

	@GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaEventoResponse> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(mapper.toDto(categoriaEventoService.findById(id))) ;
    }
    
	@GetMapping
	public ResponseEntity<List<CategoriaEventoResponse>> list() {
		return ResponseEntity.ok(categoriaEventoService.listCategoriaEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}

/* 	@GetMapping(value = "/distinct")
	public ResponseEntity<List<String>> listDistinct() {
		return ResponseEntity.ok(categoriaEventoService.listDistinct());
	} */

	/* @PostMapping
	public ResponseEntity<CategoriaEventoResponse> post(@Valid @RequestBody CategoriaEventoRequest model) {

		CategoriaEvento categoriaEvento = categoriaEventoService.createCategoriaEvento(mapper.fromDto(model));

		return ResponseEntity.ok(mapper.toDto(categoriaEvento));
	} */


	//@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	//public 

	/* @DeleteMapping(value = "/{id}") //
	public ResponseEntity<List<CategoriaEventoResponse>> delete(@PathVariable Integer id) {

		categoriaEventoService.deleteCategoriaEvento(id);

		return ResponseEntity.ok(categoriaEventoService.listCategoriaEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	} */



/* @PutMapping(value = "/{id}")
public ResponseEntity<CategoriaEventoResponse> update(@PathVariable Integer id, @RequestBody CategoriaEventoRequest newCategoriaEvento) {
	CategoriaEvento categoriaEvento = mapper.fromDto(newCategoriaEvento); 
	
	return ResponseEntity.ok(mapper.toDto(categoriaEventoService.updateCategoriaEvento(id, categoriaEvento)));
} */



}