package business;

public class ReporteNotFoundException extends RuntimeException {
    ReporteNotFoundException(Long id){
        super("Could not found the animal" + id);
    }
}
