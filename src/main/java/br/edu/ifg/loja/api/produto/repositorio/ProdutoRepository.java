package br.edu.ifg.loja.api.produto.repositorio;

import br.edu.ifg.loja.api.produto.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para persistencia de dados de produtos.
 * @author otaviocx
 */
@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    List<Produto> findByNomeContaining(String nome);
    Optional<Produto> findOne(long id);
}
