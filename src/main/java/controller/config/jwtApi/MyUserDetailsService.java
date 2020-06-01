package controller.config.jwtApi;

import business.UsuarioService;
import data.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    @Override //Aca se puede implementar la busqueda en la base de datos
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findById(usuarioService.findIDbyUsername(userName));
        return new User(usuario.getEmail(), usuario.getPassword(), new ArrayList<>());
    }

    public UserDetails loadUserByDeviceID(String deviceID) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findById(usuarioService.findIDbyDeviceID(deviceID));
        return new User("foo", "foo", new ArrayList<>());
    }


}
