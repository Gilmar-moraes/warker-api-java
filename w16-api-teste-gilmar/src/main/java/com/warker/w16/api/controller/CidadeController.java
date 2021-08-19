package com.warker.w16.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.warker.w16.api.domain.repository.CidadeRepository;
import com.warker.w16.api.domain.service.CidadeService;
import com.warker.w16.domain.model.CidadeModel;

/**
 * Controller
 * Seu principal objetivo é direcionar o fluxo da aplicação
 * mapeando e direcionado as ações recebida (request) pela 
 * camada da apresentação para os respectivos serviços da 
 * aplicação.
 * 
 * A classe CidadeController apresenta os métodos de: 
 * listar, savar, atualizar, buscar por Id específico. 
 * Sendo mapeados com os metodo get, post, put para 
 * possibilitar as acões/eventos.
 * 
 * @author Gilmar Junior
 * @since 08/2021
 * @version 1.0
 */
@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	private CidadeService cidadeService;
	
	/**
	 * Método responsável por listar todas as cidades cadastradas.
	 * @return uma lista contento as informações das cidades
	 */
	@GetMapping
	public List<CidadeModel> listarCidades(){
		return cidadeRepository.findAll();
	}
	
	/**
	 * Método responsável por adicionar novas cidades na base de dados.
	 * Para isso ele recebe as informações da cidade sendo que o mesmo 
	 * utiliza uma classe de serviço para realizar o salvamento na base de dados.
	 * 
	 * @param cidadeMetodo
	 * @return o status 201 signficando que a cidade foir salva;
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeModel adicionarCidade(@Valid @RequestBody CidadeModel cidadeMetodo) {
		return cidadeRepository.save(cidadeMetodo);
		
	}
	
	/**
	 * Método responsável por realizar a atualização das informações de uma cidade em específico.
	 * Para isso ele recebe o Id da cidade o corpo que vai ser modificado.
	 * @param cidadeId
	 * @param cidadeMetodo
	 * @return o status 200(ok) se a atulização ocorrei bem caso contrario retona um notFound.
	 */
	@PutMapping("/{cidadeId}")
	public ResponseEntity<CidadeModel> atualizarCidade(@Valid @PathVariable Long cidadeId,
			@RequestBody CidadeModel cidadeMetodo){
		if (!cidadeRepository.existsById(cidadeId)) {
			return ResponseEntity.notFound().build();
		}
		
		cidadeMetodo.setId(cidadeId);
		cidadeMetodo = cidadeService.savar(cidadeMetodo);
				return ResponseEntity.ok(cidadeMetodo);
	}
	
	/**
	 * Método que realizar a exclução das informções de uma cidade.
	 * @param cidadeId
	 * @return 
	 */
	
	@DeleteMapping
	public ResponseEntity<Void> excluirCliente(@PathVariable Long cidadeId){
		if (!cidadeRepository.existsById(cidadeId)) {
			return ResponseEntity.notFound().build();
		}
		
		cidadeService.excluir(cidadeId);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * 	Método que buscar uma cidade específico na base da dados.
	 * @param cidadeId
	 * @return
	 */
	@GetMapping("/{cidadeId}")
	public ResponseEntity<CidadeModel> buscarPorId(@PathVariable Long cidadeId){
		return cidadeRepository.findById(cidadeId)
				.map(cidade->ResponseEntity.ok(cidade))
				.orElse(ResponseEntity.notFound().build());
	}
}
