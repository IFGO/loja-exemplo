package br.edu.ifg.loja.produto.repositorio;

import br.edu.ifg.loja.produto.Imagem;
import br.edu.ifg.loja.produto.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para persistencia de dados de produtos.
 * @author otaviocx
 */
public interface ImagemRepository extends CrudRepository<Imagem, Long> {

}
