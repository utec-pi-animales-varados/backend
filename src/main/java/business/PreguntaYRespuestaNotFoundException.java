package business;

public class PreguntaYRespuestaNotFoundException extends RuntimeException{
    public PreguntaYRespuestaNotFoundException(Long id) {
        super("Could not find the question and answer " + id);
    }
}
