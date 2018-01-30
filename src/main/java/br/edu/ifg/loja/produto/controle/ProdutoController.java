package br.edu.ifg.loja.produto.controle;

import br.edu.ifg.loja.produto.Produto;
import br.edu.ifg.loja.produto.repositorio.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador responsavel por disponibilizar end-points de gestao de produtos
 * @author otaviocx
 */
@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public Iterable<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void removerProduto(@PathVariable Long id) {
        produtoRepository.delete(id);
    }

}
