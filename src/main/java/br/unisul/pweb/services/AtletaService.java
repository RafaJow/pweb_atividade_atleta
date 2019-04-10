package br.unisul.pweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Atleta;
import br.unisul.pweb.domain.Competicao;
import br.unisul.pweb.repository.AtletaRepository;
import br.unisul.pweb.repository.CompeticaoRepository;

@Service
public class AtletaService {

	@Autowired
	private AtletaRepository rep;
	
	//BUSCAR POR ID
	public Atleta find (Integer id) {
		Optional<Atleta> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	
	//LISTAR TODOS
	public List<Atleta> findAll(){
		return rep.findAll();
	}
	
}
