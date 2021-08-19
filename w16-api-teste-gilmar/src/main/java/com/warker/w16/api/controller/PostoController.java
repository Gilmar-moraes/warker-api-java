package com.warker.w16.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.warker.w16.api.domain.repository.PostoRepository;
import com.warker.w16.api.domain.service.PostoService;
import com.warker.w16.domain.model.PostoModel;

/**
 * A classe PostoController apresenta os métodos de: 
 * listar, savar, atualizar, buscar por Id específico. 
 * Sendo mapeados com os metodo get, post, put para 
 * possibilitar as acões/eventos.
 * 
 * @author Gilmar Junior
 * @since 08/2021
 * @version 1.0
 * 
 * obs.: passar o corpo dos métodos para a classe service.
 * obs.: os métodos listar, buscarPorId, atualizar e excluir estão funcionando
 *       mas método de adicionar não esta funcionando. (não sei o pq, nessa hora que solicitaria ajuda)
 * 
 */
@RestController
@RequestMapping("/postos")
public class PostoController {
	
	@Autowired
	private PostoRepository postoRepository;
	
	private PostoService postoService;
	
	/**
	 * Método que retona uma lista contendo as informações das cidades e as dos postos.
	 * @return lista contendo as informações da cidade e as do post
	 */
	@GetMapping
	public List<PostoModel> listar(){
		return postoRepository.findAll();
	}
	
	/**
	 * Método responsável por realizar uma busca na base de dados atraves de um id específico
	 * @param idPost
	 * @return uma lista contendo todas as informações associada a cidade e ao posto
	 */
	@GetMapping("/{idPosto}")
	public ResponseEntity<PostoModel> buscarPorId(@PathVariable Long idPosto){
		
		return postoRepository.findById(idPosto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	/**
	 * Método que adiciona um novo posto a base de dados recebendo
	 * como parâmetro um corpo contendo as informações.
	 * @param postoModel
	 * @return uma um estatos de criação - 201
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PostoModel adicionarPosto(@Valid @RequestBody PostoModel postoModel) {
		return postoService.salvar(postoModel);
	}
	
	/**
	 * Método que atualizar as informações de um determinado posto.
	 * Para isso ele recebe o id do posto que se deseja modificar além do corpo. 
	 * @param idPosto
	 * @param postoModel
	 * @return o estatos 200
	 */
	@PutMapping("/{idPosto}")
	public ResponseEntity<PostoModel> atualizarPosto(@Valid @PathVariable Long idPosto,
			PostoModel postoModel){
		
		if (!postoRepository.existsById(idPosto)) {
			return ResponseEntity.notFound().build();
		}
		
		postoModel.setId(idPosto);
		postoModel = postoRepository.save(postoModel);
		return ResponseEntity.ok(postoModel);
	}
	/**
	 * Método responsável por excluir determindo posto da base de dados.
	 * @param idPosto
	 * @return void
	 */
	public ResponseEntity<Void> excluirPosto(@PathVariable Long idPosto){
		if (!postoRepository.existsById(idPosto)) {
			return ResponseEntity.notFound().build();
		}
		
		postoService.excluir(idPosto);
		return ResponseEntity.noContent().build();
	}
}
