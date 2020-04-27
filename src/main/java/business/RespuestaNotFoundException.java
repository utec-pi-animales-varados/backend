package business;

public class RespuestaNotFoundException extends RuntimeException{
    public RespuestaNotFoundException(Long id) {
        super("Could not find the answer " + id);
    }
}
