package br.com.arthurrocha.springbootcommysql.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arthurrocha.springbootcommysql.controller.dto.PessoaRs;
import br.com.arthurrocha.springbootcommysql.model.Pessoa;
import br.com.arthurrocha.springbootcommysql.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	private final PessoaRepository pessoaRepository;
	
	public PessoaController(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@GetMapping("/")
	public List<PessoaRs> findAll(){
		List<Pessoa> pessoas = pessoaRepository.findAll();
		return pessoas
				.stream()
				.map(PessoaRs::converter)
				.collect(Collectors.toList());
	}
}
