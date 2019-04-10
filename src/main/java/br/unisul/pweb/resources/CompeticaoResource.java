package br.unisul.pweb.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unisul.pweb.domain.Competicao;
import br.unisul.pweb.dtos.CompeticaoDTO;
import br.unisul.pweb.services.CompeticaoService;

@RestController
@RequestMapping(value="/competicoes")
public class CompeticaoResource {

	@Autowired
	private CompeticaoService service;
	
	//BUSCAR POR ID
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Competicao> find(@PathVariable Integer id){
		Competicao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	//LISTAR TODOS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CompeticaoDTO>> findAll() {
		List<Competicao> lista = service.findAll();
		List<CompeticaoDTO> listaDTO = new ArrayList<CompeticaoDTO>();
		for (Competicao c : lista) {
			listaDTO.add(new CompeticaoDTO(c));
		}
		return ResponseEntity.ok().body(listaDTO);
	}
}
