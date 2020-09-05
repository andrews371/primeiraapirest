package com.livraria.apirest.resource;

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

import com.livraria.apirest.models.Livro;
import com.livraria.apirest.repository.LivroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Livros")
@CrossOrigin(origins="*") // qualquer domínio pode acessar a api
public class LivroResource {
	
	@Autowired
	LivroRepository livroRepository;
	
	@GetMapping("/livros") //caminho: http://localhost:8080/api/livros
	@ApiOperation(value="Retorna uma lista de livros")
	public List<Livro> listaLivros(){
		return livroRepository.findAll();
	}
	
	@GetMapping("/livro/{id}") 
	@ApiOperation(value="Retorna um livro único por ID")
	public Livro listaLivroUnico(@PathVariable(value="id") long id){
		return livroRepository.findById(id);
	}
	
	@PostMapping("/livro")
	@ApiOperation(value="Salva um livro")
	public Livro salvaLivro(@RequestBody Livro livro) {
		return livroRepository.save(livro);
	}
	
	@DeleteMapping("/livro")
	@ApiOperation(value="Deleta um livro")
	public void deletaLivro(@RequestBody Livro livro) {
		livroRepository.delete(livro);
	}
	
	@PutMapping("/livro")
	@ApiOperation(value="Atualiza um livro")
	public Livro atualizaLivro(@RequestBody Livro livro) {
		return livroRepository.save(livro);
	}
}
