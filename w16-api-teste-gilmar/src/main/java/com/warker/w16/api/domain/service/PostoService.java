package com.warker.w16.api.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.warker.w16.api.domain.repository.PostoRepository;
import com.warker.w16.domain.model.PostoModel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Classe contendo as regras de negócios. 
 * @author Gilmar Junior
 * @version 1.0
 * @since 08/2021
 *
 * Os dois métodos presentes nesta classe estão anotados com a
 * '@Transactional' pois é uma unidade de trabalho isolada que
 * leva o banco de dados de um estado consistente a outro estado consistente.
 *
 * obs.: para a versão 1.2 migrar todas a regras de negócio para esta classe.
 */

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PostoService {

	private PostoRepository postoRepository;
	
	/**
	 * Método que excluir um determinado posto.
	 * @param postoId
	 */
	@Transactional
	public void excluir(Long postoId) {
		postoRepository.deleteById(postoId);
	}
	
	/**
	 * Método responsável por salvar um posto 
	 * @param posto
	 * @return
	 */
	@Transactional
	public PostoModel salvar(PostoModel posto) {
		return postoRepository.save(posto);
	}
}
