package controller.config.jwtApi;

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

    @Override //Aca se puede implementar la busqueda en la base de datos
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new User("foo","foo", new ArrayList<>());
    }

}
