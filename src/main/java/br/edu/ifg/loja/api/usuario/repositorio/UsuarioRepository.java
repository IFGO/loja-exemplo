package br.edu.ifg.loja.api.usuario.repositorio;

import br.edu.ifg.loja.api.usuario.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio para persistencia de dados de usuarios.
 * @author otaviocx
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Optional<Usuario> findOne(long id);
}
