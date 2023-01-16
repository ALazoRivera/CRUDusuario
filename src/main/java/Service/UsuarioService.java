package Service;


import Domain.Usuario;
import Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repousuario;

    public List<Usuario> listar() {
        return repousuario.findAll();
    }

    public Optional<Usuario> findByid(long id) {
        return repousuario.findById(id);
    }

    public void guardar(Usuario usuario) {
        repousuario.save(usuario);
    }

    public void eliminar(Usuario usuario) {

        repousuario.delete(usuario);
    }
}
