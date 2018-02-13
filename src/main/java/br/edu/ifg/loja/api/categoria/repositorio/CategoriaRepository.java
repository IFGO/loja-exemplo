package br.edu.ifg.loja.api.categoria.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifg.loja.api.categoria.Categoria;

/**
 * Repositorio para persistencia de dados de categorias.
 * 
 * @author RamonKenedy
 */
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	List<Categoria> findByNomeContaining(String nome);

	Optional<Categoria> findOne(long id);
}