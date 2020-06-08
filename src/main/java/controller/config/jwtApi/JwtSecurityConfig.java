package controller.config.jwtApi;

import business.UsuarioService;
import controller.config.util.JwtUtil;
import data.dto.AuthenticateDTO;
import data.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
class JwtSecurityConfig{

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
        public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateDTO authenticationRequest) throws Exception {
            if (service.findByUsernameAndPassword(authenticationRequest.getEmail(), authenticationRequest.getPassword())) {
                final UserDetails userDetails = userDetailsService
                        .loadUserByUsername(authenticationRequest.getEmail());
                final Long user_id = service.findIDbyUsername(authenticationRequest.getEmail());
                final String jwt = jwtTokenUtil.generateToken(userDetails);
                HashMap<String, String> map = new HashMap<>();
                map.put("user_id", Long.toString(user_id));
                map.put("jwt", jwt);
                return new ResponseEntity<>(map, HttpStatus.OK);
            }
            return new ResponseEntity<>("Usuario o contraseña invalida", HttpStatus.BAD_REQUEST);
        }

        @RequestMapping(value = "/authenticateGuest", method = RequestMethod.POST)
        public ResponseEntity<?> createGuestAuthenticationToken(@RequestBody Usuario user) throws Exception {
            if (service.deviceIdExists(user.getDeviceId())) {
                final Long user_id = service.findIDbyDeviceID(user.getDeviceId());
                final String jwt = jwtTokenUtil.generateAnonymousToken(user);
                HashMap<String, String> map = new HashMap<>();
                map.put("user_id", Long.toString(user_id));
                map.put("jwt", jwt);
                return new ResponseEntity<>(map, HttpStatus.OK);
            }
            return new ResponseEntity<>("User ID invalido", HttpStatus.BAD_REQUEST);
        }
}
