package br.unisul.pweb.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Atleta;
import br.unisul.pweb.domain.Competicao;
import br.unisul.pweb.repository.AtletaRepository;
import br.unisul.pweb.repository.CompeticaoRepository;

@Service
public class DbService {
	
	@Autowired
	private AtletaRepository atletaRepository;
	
	@Autowired
	private CompeticaoRepository competicaoRepository;

	public void inicializaBancoDeDados() throws ParseException {
		
		Atleta at1 = new Atleta(null, "Joao");
		Atleta at2 = new Atleta(null, "Carlos");
		Atleta at3 = new Atleta(null, "Baiano");
		
		Competicao co1 = new Competicao(null, "Caminhada", "01-01-2019");
		Competicao co2 = new Competicao(null, "Pedal", "02-01-2019");
		
		at1.getCompeticoes().addAll(Arrays.asList(co1));
		at2.getCompeticoes().addAll(Arrays.asList(co2));
		at3.getCompeticoes().addAll(Arrays.asList(co1, co2));
		
		co1.getAtletas().addAll(Arrays.asList(at1, at3));
		co2.getAtletas().addAll(Arrays.asList(at2, at3));
		
		competicaoRepository.saveAll(Arrays.asList(co1, co2));
		atletaRepository.saveAll(Arrays.asList(at1, at2, at3));
		
		
	}
}
