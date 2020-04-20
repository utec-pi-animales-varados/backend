package controller;

public class UsuarioNotFoundException extends RuntimeException{

    UsuarioNotFoundException(Long id){
        super("Could not find the user " + id);
    }
}
