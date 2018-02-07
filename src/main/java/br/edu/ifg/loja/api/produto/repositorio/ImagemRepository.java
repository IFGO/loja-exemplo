package br.edu.ifg.loja.api.produto.repositorio;

import br.edu.ifg.loja.api.produto.Imagem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para persistencia de dados de produtos.
 * @author otaviocx
 */
@Repository
public interface ImagemRepository extends CrudRepository<Imagem, Long> {

}
