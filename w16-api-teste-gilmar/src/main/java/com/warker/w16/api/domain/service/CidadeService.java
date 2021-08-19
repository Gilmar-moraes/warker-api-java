package com.warker.w16.api.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.warker.w16.api.domain.repository.CidadeRepository;
import com.warker.w16.domain.model.CidadeModel;

import lombok.AllArgsConstructor;

/**
 * Classe contendo as regras de negócios.
 * @author Gilmar Junior
 * @version 1.0
 * @since 08/2021
 *
 * 
 * Os dois métodos presentes nesta classe estão anotados com a
 * '@Transactional' pois é uma unidade de trabalho isolada que
 * leva o banco de dados de um estado consistente a outro estado consistente.
 *
 * obs.: para a versão 1.2 migrar todas a regras de negócio para esta classe.
 */
@AllArgsConstructor
@Service
public class CidadeService {
	
	private CidadeRepository cidadeRepository;
	
	/**
	 * Método responsável por salvar uma nova cidade.
	 * Sendo que para isso ele verificar ser exixter 
	 * o nomer da cidade na base.
	 * @param cidadeModel
	 * @return uma estatus de criação -201
	 */
	
	@Transactional
	public CidadeModel savar(CidadeModel cidadeModel) {
		boolean nomeCidadeEmUso = cidadeRepository.findByNomeDaCidade(cidadeModel.getNomeDaCidade())
				.stream()
				.anyMatch(cidadeExistente -> !cidadeExistente.equals(cidadeModel));
		if (nomeCidadeEmUso) {
			System.out.println("nome existe");
			System.exit(0);
		}
		
		return cidadeRepository.save(cidadeModel);
	}
	
	/**
	 * Método que excluir uma cidade na base.
	 * @param clienteId
	 */
	@Transactional
	public void excluir(Long clienteId) {
		cidadeRepository.deleteById(clienteId);
	}
}
