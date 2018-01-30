package br.edu.ifg.loja.produto.controle;

import br.edu.ifg.loja.commons.exceptions.NaoEncontradoException;
import br.edu.ifg.loja.commons.exceptions.ParametrosInvalidosException;
import br.edu.ifg.loja.produto.Produto;
import br.edu.ifg.loja.produto.repositorio.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/nome/{nome}")
    public List<Produto> buscarPorNome(@PathVariable String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

    @GetMapping("/{id}")
    public Produto buscarPeloId(@PathVariable Long id) {
        return produtoRepository.findOneOptional(id)
                .orElseThrow(NaoEncontradoException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void removerProduto(@PathVariable Long id) {
        produtoRepository.findOneOptional(id).orElseThrow(NaoEncontradoException::new);
        produtoRepository.delete(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@RequestBody Produto produto, @PathVariable Long id) {
        if (produto.getId() == null || !produto.getId().equals(id)) {
            throw new ParametrosInvalidosException("O id do produto deve ser informado corretamente", null);
        }
        produtoRepository.findOneOptional(id).orElseThrow(NaoEncontradoException::new);
        return produtoRepository.save(produto);
    }

}
