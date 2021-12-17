package br.com.emmanuelneri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.emmanuelneri.model.Pessoa;
import br.com.emmanuelneri.repository.PessoaRepository;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class PessoaController {
	
	@Autowired
    private PessoaRepository repository;
	 
	 
	@GetMapping("/listarTodos")
	public ResponseEntity<List<Pessoa>> listarTodos() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("{id}")
	public Pessoa acharPorId(@PathVariable Integer id) {
		return repository
				.findById(id).get();
				
	}

    @PostMapping("/salvar")
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(repository.save(pessoa));
    }
    
    @DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		repository.deleteById(id); 
	}
    
    @PutMapping("/alterar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Pessoa atualizar(@RequestBody Pessoa pessoaAtualizado) {
		return repository.save(pessoaAtualizado);
				
				
	} 

}
