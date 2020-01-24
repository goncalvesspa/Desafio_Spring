package com.example.desafio_v2.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;



import com.example.desafio_v2.domain.dto.request.ParticipacaoRequest;
import com.example.desafio_v2.domain.dto.response.ParticipacaoResponse;
import com.example.desafio_v2.domain.entities.Participacao;
import com.example.desafio_v2.domain.mapper.ParticipacaoMapper;
import com.example.desafio_v2.service.ParticipacaoService;

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
@RequestMapping("/participacao")
public class ParticipacaoController {

	private final ParticipacaoService participacaoService;
	private final ParticipacaoMapper mapper;

	@Autowired
	public ParticipacaoController(ParticipacaoService participacaoService, ParticipacaoMapper participacaoMapper) {
		this.participacaoService = participacaoService;
		this.mapper = participacaoMapper;
	}

	@GetMapping(value = "/{id}")
    public ResponseEntity<ParticipacaoResponse> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(mapper.toDto(participacaoService.findById(id))) ;
    }
    
	@GetMapping
	public ResponseEntity<List<ParticipacaoResponse>> list() {
		return ResponseEntity.ok(participacaoService.listParticipacao().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}

	@GetMapping(value = "/distinct")
	public ResponseEntity<List<String>> listDistinct() {
		return ResponseEntity.ok(participacaoService.listDistinct());
	}

	@PostMapping
	public ResponseEntity<ParticipacaoResponse> post(@Valid @RequestBody ParticipacaoRequest model) {

		Participacao participacao = participacaoService.createParticipacao(mapper.fromDto(model));

		return ResponseEntity.ok(mapper.toDto(participacao));
	}


	//@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	//public 

	@DeleteMapping(value = "/{id}") //
	public ResponseEntity<List<ParticipacaoResponse>> delete(@PathVariable Integer id) {

		participacaoService.deleteParticipacao(id);

		return ResponseEntity.ok(participacaoService.listParticipacao().stream() //
				.map(x -> mapper.toDto(x)) //
				.collect(Collectors.toList()));
	}



@PutMapping(value = "/{id}")
public ResponseEntity<ParticipacaoResponse> update(@PathVariable Integer id, @RequestBody ParticipacaoRequest newParticipacao) {
	Participacao evento = mapper.fromDto(newParticipacao); 
	
	return ResponseEntity.ok(mapper.toDto(participacaoService.updateParticipacao(id, evento)));
}



}