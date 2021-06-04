package com.aplicacao.apiescola.apiescola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.apiescola.apiescola.model.Aluno;
import com.aplicacao.apiescola.apiescola.repository.AlunoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/alunos")
@Api(value="API REST Escola")
@CrossOrigin(origins="*")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping()
	@ApiOperation(value="Retorna uma lista de alunos")
	public List<Aluno> listarAlunos(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{idAluno}")
	@ApiOperation(value="Retorna apenas um aluno")
	public Aluno listarAlunoPorId(@PathVariable(value = "idAluno")long idAluno){
		return alunoRepository.findById(idAluno);
	}
	
	
	@PostMapping
	@ApiOperation(value="Adiciona um aluno")
	public Aluno adicionarAluno(@RequestBody Aluno aluno) throws Exception {	
		return alunoRepository.save(aluno);
	}
	
	@PutMapping("/{idAluno}")
	@ApiOperation(value="Atualizar um aluno")
    public Aluno atualizarAluno(@PathVariable(value = "idAluno")long idAluno, @RequestBody Aluno aluno){
        aluno.setIdAluno(idAluno);
		return alunoRepository.save(aluno);
    }
	
	@DeleteMapping("/{idAluno}")
	@ApiOperation(value="Exclui um aluno")
	public void excluirAluno(@PathVariable(value = "idAluno")long idAluno) {
		alunoRepository.deleteById(idAluno);
	}
	

}
