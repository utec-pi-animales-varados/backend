package business;

public class PreguntaNotFoundException extends RuntimeException {
    public PreguntaNotFoundException(Long id) {
        super("Could not find the question " + id);
    }
}
