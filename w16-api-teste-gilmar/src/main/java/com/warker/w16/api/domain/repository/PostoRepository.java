package com.warker.w16.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warker.w16.domain.model.PostoModel;

/**
 * Interfaer responsável por por conte as assinaturas dos métodos sendo utilizados nas classes de controller ou service.
 * 
 * Obs.: esta vazia pois não foi necessário a cria novos métodos, 
 * sendo que esta anotada com '@Repository' e herdar de 
 * outra classe métodos que estou utilizando.
 * @author Gilmar Junior
 * @version 1.0
 * @since 08/2021
 *
 */
@Repository
public interface PostoRepository extends JpaRepository<PostoModel, Long>{

}
