package cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n01.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(FruitNotFoundException.class)
    public ResponseEntity<ExceptionDetails> fruitNotFoundException(FruitNotFoundException exception) {
        ExceptionDetails details = new ExceptionDetails(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}
