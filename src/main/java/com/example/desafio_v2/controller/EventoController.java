package com.example.desafio_v2.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import com.example.desafio_v2.domain.dto.request.EventoRequest;
import com.example.desafio_v2.domain.dto.request.EventoUpdate;
import com.example.desafio_v2.domain.dto.response.EventoResponse;
import com.example.desafio_v2.domain.entities.Evento;
import com.example.desafio_v2.domain.mapper.EventoMapper;
import com.example.desafio_v2.service.CategoriaEventoService;
import com.example.desafio_v2.service.EventoService;
import com.example.desafio_v2.service.StatusEventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController {

	private final EventoService eventoService;
	private final EventoMapper mapper;
	private final CategoriaEventoService categoriaEventoService;
	private final StatusEventoService statusEventoService;

	@Autowired
	public EventoController(EventoService eventoService, EventoMapper eventoMapper,CategoriaEventoService categoriaEventoService,
	StatusEventoService statusEventoService) {
		this.eventoService = eventoService;
		this.mapper = eventoMapper;
		this.statusEventoService = statusEventoService;
		this.categoriaEventoService = categoriaEventoService;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EventoResponse> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(mapper.toDto(eventoService.findById(id)));
	}

	@GetMapping
	public ResponseEntity<List<EventoResponse>> list() {
		return ResponseEntity.ok(eventoService.listEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}

	@GetMapping(value = "/distinct")
	public ResponseEntity<List<String>> listDistinct() {
		return ResponseEntity.ok(eventoService.listDistinct());
	}

	@PostMapping
	public ResponseEntity<EventoResponse> post(@Valid @RequestBody EventoRequest model) {
		Evento evento = mapper.fromDto(model);
		evento.setIdEventoStatus(statusEventoService.findById(1));
		evento.setIdCategoriaEvento(categoriaEventoService.findById(model.getIdCategoriaEvento()));
		
		Evento e = eventoService.createEvento(evento);

		return ResponseEntity.ok(mapper.toDto(e));
	}

	// @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	// public

	@DeleteMapping(value = "/{id}") //
	public ResponseEntity<List<EventoResponse>> delete(@PathVariable Integer id) {

		eventoService.deleteEvento(id);

		return ResponseEntity.ok(eventoService.listEvento().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EventoResponse> update(@PathVariable Integer id, @Valid @RequestBody EventoUpdate newEvento) {
		Evento evento = mapper.fromDto(newEvento);
		evento.setIdEventoStatus(statusEventoService.findById(newEvento.getIdEventoStatus()));
		return ResponseEntity.ok(mapper.toDto(eventoService.updateEvento(id, evento)));
		
	}

	/* @PutMapping(value = "/{id}")
	public ResponseEntity<EventoResponse> update(@PathVariable Integer id, @RequestBody EventoUpdate newEvento){
		return false;
	} */

	@PutMapping(value = "/{id}")
	public ResponseEntity<EventoResponse> update2(@PathVariable Integer id) { //Meu put terá dois campos para o usuario digitar o id do evento e o id do status do evento, preciso mandar isso para meu service
		
		
		return ResponseEntity.ok(mapper.toDto(eventoService.cancelar(id)));
		
	}

}