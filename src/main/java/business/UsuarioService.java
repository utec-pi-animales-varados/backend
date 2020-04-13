package business;

import data.entities.Usuario;
import data.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

/*
    public List<Usuario> findAll(){
        List<Usuario> items = new ArrayList<>();
        for(Usuario item : repository.findAll()){
            items.add(item);
        }
        return items;
    }

    public Optional<Usuario> findOne(Long id){
        return repository.findById(id);
    }

    public Usuario create(Usuario item){
        return repository.save(item);
    }

    public Usuario update(Usuario item){
        return repository.save(item);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
*/


}
