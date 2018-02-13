package br.edu.ifg.loja.api.categoria.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifg.loja.api.categoria.Categoria;
import br.edu.ifg.loja.api.categoria.repositorio.CategoriaRepository;
import br.edu.ifg.loja.api.commons.exceptions.NaoEncontradoException;
import br.edu.ifg.loja.api.commons.exceptions.ParametrosInvalidosException;

/**
 * Controlador responsavel por disponibilizar end-points de gestao de categorias
 * 
 * @author RamonKenedy
 */
@RestController
@RequestMapping("api/categorias")
public class CategoriaController {

	private CategoriaRepository categoriaRepository;

	@Autowired
	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@GetMapping
	public Iterable<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}

	@GetMapping("/nome/{nome}")
	public List<Categoria> buscarPorNome(@PathVariable String nome) {
		return categoriaRepository.findByNomeContaining(nome);
	}

	@GetMapping("/{id}")
	public Categoria buscarPeloId(@PathVariable long id) {
		return categoriaRepository.findOne(id).orElseThrow(NaoEncontradoException::new);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria criarCategoria(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@DeleteMapping("/{id}")
	public void removerCategoria(@PathVariable long id) {
		categoriaRepository.findOne(id).orElseThrow(NaoEncontradoException::new);
		categoriaRepository.delete(id);
	}

	@PutMapping("/{id}")
	public Categoria atualizarCategoria(@RequestBody Categoria categoria, @PathVariable long id) {
		if (categoria.getId() == null || !categoria.getId().equals(id)) {
			throw new ParametrosInvalidosException("O id da categoria deve ser informado corretamente", null);
		}
		categoriaRepository.findOne(id).orElseThrow(NaoEncontradoException::new);
		return categoriaRepository.save(categoria);
	}

}
