package controller.config.jwtApi;

import business.UsuarioService;
import data.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    @Override //Aca se puede implementar la busqueda en la base de datos
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Long id = usuarioService.findIDbyUsername(userName);
        if(id != null){
            Usuario usuario = usuarioService.findById(id);
            return new User(usuario.getEmail(), usuario.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("Username not found");
        }
    }

    public UserDetails loadUserByDeviceID(String deviceID) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findById(usuarioService.findIDbyDeviceID(deviceID));
        return new User(deviceID, "foo", new ArrayList<>());
    }


}
