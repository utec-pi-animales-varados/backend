package controller.config.jwtApi;

import business.UsuarioService;
import controller.config.util.JwtUtil;
import models.AuthenticationRequest;
import models.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
class JwtSecurityConfig {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private JwtUtil jwtTokenUtil;

        @Autowired
        private MyUserDetailsService userDetailsService;

        @RequestMapping("/test")
        public String firstPage() {
            return "Hello World";
        }


        @Autowired
        private UsuarioService service;

        @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
        public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

            if(service.findByUsernameAndPassword(authenticationRequest.getUsername(),authenticationRequest.getPassword())) {
                final UserDetails userDetails = userDetailsService
                        .loadUserByUsername(authenticationRequest.getUsername());

                final String jwt = jwtTokenUtil.generateToken(userDetails);
                return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Usuario o contraseña invalida", HttpStatus.BAD_REQUEST);
            }
        }
}
