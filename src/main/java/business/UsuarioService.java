package business;

import controller.UsuarioNotFoundException;
import data.entities.Usuario;
import data.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario save(Usuario newUsuario){
        return repository.save(newUsuario);
    }

    public Usuario findById(Long id){
        return repository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public Usuario update(Usuario newUsuario, Long id){
        return repository.findById(id).map(usuario -> {
            usuario.setName(newUsuario.getName());
            usuario.setLastName(newUsuario.getLastName());
            usuario.setEmail(newUsuario.getEmail());
            usuario.setPassword(newUsuario.getPassword());
            usuario.setReportes(newUsuario.getReportes());
            usuario.setTelephone(newUsuario.getTelephone());
            usuario.setMobilePhone(newUsuario.getMobilePhone());
            return repository.save(usuario);
        }).orElseGet(()->{
            newUsuario.setId(id);
            return repository.save(newUsuario);
        });
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
