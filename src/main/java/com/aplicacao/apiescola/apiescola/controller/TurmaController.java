package com.aplicacao.apiescola.apiescola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.apiescola.apiescola.model.Turma;
import com.aplicacao.apiescola.apiescola.repository.TurmaRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping
	public List<Turma> listarTurmas(){
		return turmaRepository.findAll();
	}
	
	@PostMapping
	public Turma adicionarTurma(@RequestBody Turma turma) throws Exception{
		List<Turma> turmas = this.listarTurmas();
		for(Turma itemTurma: turmas) {
			if(turma.getNomeTurma().equals(itemTurma.getNomeTurma())) {
				throw new Exception("Esta turma já existe!");
			}
		}
		return turmaRepository.save(turma);			
	}
	
	
	@GetMapping("/{idTurma}")
	public Turma buscaTurmaPorId(@PathVariable(value = "idTurma")long idTurma) {
		return turmaRepository.findById(idTurma);
	}
	
	@PutMapping("/{idTurma}")
	@ApiOperation(value="Atualizar uma turma")
    public Turma atualizarTurma(@PathVariable(value = "idAluno")long idTurma, @RequestBody Turma turma){
        turma.setIdTurma(idTurma);
		return turmaRepository.save(turma);
    }
	
	
	@DeleteMapping("/{idTurma}")
	public void excluirAluno(@PathVariable(value = "idTurma")long idTurma) {
		turmaRepository.deleteById(idTurma);
	}

}
