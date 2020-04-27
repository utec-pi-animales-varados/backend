package business;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ReporteNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ReporteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reporteNotFoundHandler(ReporteNotFoundException ex) {
        return ex.getMessage();
    }
}
