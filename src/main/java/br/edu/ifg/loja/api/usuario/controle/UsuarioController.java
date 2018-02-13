package br.edu.ifg.loja.api.usuario.controle;

import br.edu.ifg.loja.api.usuario.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador responsavel por disponibilizar end-points de gestao de usuarios
 * @author otaviocx
 */
@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @DeleteMapping("/{id}")
    public void removerUsuario(@PathVariable Long id) {
        usuarioRepository.delete(id);
    }

}
