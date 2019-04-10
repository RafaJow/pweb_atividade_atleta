package br.unisul.pweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Competicao;
import br.unisul.pweb.repository.CompeticaoRepository;

@Service
public class CompeticaoService {

	@Autowired
	private CompeticaoRepository rep;
	
	//BUSCAR POR ID
	public Competicao find (Integer id) {
		Optional<Competicao> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	//LISTAR TODOS
	public List<Competicao> findAll(){
		return rep.findAll();
	}
}
