package business;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(Long id){
        super("Could not find the user " + id);
    }
}
