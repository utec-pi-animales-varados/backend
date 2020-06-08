package business;

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
            usuario.setTelephone(newUsuario.getTelephone());
            usuario.setMobilePhone(newUsuario.getMobilePhone());
            usuario.setReportes(newUsuario.getReportes());
            usuario.setDeviceId((newUsuario.getDeviceId()));
            return repository.save(usuario);
        }).orElseGet(()->{
            newUsuario.setId(id);
            return repository.save(newUsuario);
        });
    }

    public void deleteById(Long id){ repository.deleteById(id); }

    public Boolean findByUsernameAndPassword(String email, String password){
        for(Usuario item : repository.findAll()){
            if((item.getEmail().equals(email)) & (item.verifyPassword(password))){
                return true;
            }
        }
        return false;
    }

    public Long findIDbyUsername(String email) {
        for (Usuario item : repository.findAll())
            if (item.getEmail() != null && item.getEmail().equals(email))
                return item.getId();
        return null;
    }

    public Boolean deviceIdExists(String deviceID) {
        for (Usuario item : repository.findAll())
            if (item.getDeviceId().equals(deviceID))
                return true;
        return false;
    }

    public Long findIDbyDeviceID(String devideID) {
        for (Usuario item : repository.findAll())
            if (item.getDeviceId().equals(devideID))
                return item.getId();
        return null;
    }

}
