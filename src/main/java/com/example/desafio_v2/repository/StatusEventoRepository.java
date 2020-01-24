package com.example.desafio_v2.repository;
import java.util.List;



import com.example.desafio_v2.domain.entities.StatusEvento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusEventoRepository extends JpaRepository<StatusEvento, Integer> {

	//void updateClient(Integer id);
	@Query(nativeQuery = true, value = "select distinct name from Client")
    List<String> listDistinct();

} 