package com.warker.w16.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warker.w16.domain.model.CidadeModel;

/**
 * Interfaer responsável por por conte as assinaturas dos 
 * métodos sendo utilizados nas classes de controller ou de service. 
 * @author Gilmar Junior
 * @version 1.0
 * @since 08/2021
 *
 */
@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Long>{
	
	List<CidadeModel> findByNomeDaCidade(String nomeCidade);
}
