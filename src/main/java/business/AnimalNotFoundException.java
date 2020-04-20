package business;

public class AnimalNotFoundException extends RuntimeException {
    AnimalNotFoundException(Long id){
        super("Could not found the animal" + id);
    }
}
