package business;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AnimalNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PreguntaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String animalNotFoundHandler(AnimalNotFoundException ex) {
        return ex.getMessage();
    }
}
