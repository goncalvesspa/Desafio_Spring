package com.example.desafio_v2.repository;
import java.util.List;



//import com.example.desafio_v2.domain.entities.;

import com.example.desafio_v2.domain.entities.Participacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer> {

	//void updateClient(Integer id);
	@Query(nativeQuery = true, value = "select distinct name from Client")
    List<String> listDistinct();

} 