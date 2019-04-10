package br.unisul.pweb.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unisul.pweb.domain.Atleta;
import br.unisul.pweb.dtos.AtletaDTO;
import br.unisul.pweb.services.AtletaService;

@RestController
@RequestMapping(value="/atletas")
public class AtletaResource {

	@Autowired
	private AtletaService service;
	
	//BUSCAR POR ID
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Atleta> find(@PathVariable Integer id){
		Atleta obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//LISTAR TODOS
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<AtletaDTO>> findAll() {
			List<Atleta> lista = service.findAll();
			List<AtletaDTO> listaDTO = new ArrayList<AtletaDTO>();
			for (Atleta a : lista) {
				listaDTO.add(new AtletaDTO(a));
			}
			return ResponseEntity.ok().body(listaDTO);
		}
}
