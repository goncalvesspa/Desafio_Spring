package com.example.desafio_v2.controller;

import java.util.List;
import java.util.stream.Collectors;




import com.example.desafio_v2.domain.dto.response.StatusEventoResponse;

import com.example.desafio_v2.domain.mapper.StatusEventoMapper;
import com.example.desafio_v2.service.StatusEventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/StatusEventoController")
public class StatusEventoController {

	private final StatusEventoService statusEventoService;
	private final StatusEventoMapper mapper;

	@Autowired
	public StatusEventoController(StatusEventoService statusEventoService, StatusEventoMapper statusEventoMapper) {
		this.statusEventoService = statusEventoService;
		this.mapper = statusEventoMapper;
	}

	@GetMapping(value = "/{id}")
    public ResponseEntity<StatusEventoResponse> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(mapper.toDto(statusEventoService.findById(id))) ;
    }
    
	@GetMapping
	public ResponseEntity<List<StatusEventoResponse>> list() {
		return ResponseEntity.ok(statusEventoService.listStatusEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}

	@GetMapping(value = "/distinct")
	public ResponseEntity<List<String>> listDistinct() {
		return ResponseEntity.ok(statusEventoService.listDistinct());
	}

	/* @PostMapping
	public ResponseEntity<StatusEventoResponse> post(@Valid @RequestBody StatusEventoRequest model) {

		StatusEvento statusEvento = statusEventoService.createStatusEvento(mapper.fromDto(model));

		return ResponseEntity.ok(mapper.toDto(statusEvento));
	} */


	


}