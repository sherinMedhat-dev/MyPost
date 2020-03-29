package pharos.solutions.ExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> handleConstraintViolationException(HttpServletRequest request, Exception ex) {
      return   new ResponseEntity<Object>(
                "Aproblem occured due to: " + ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);

    }
    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleException(HttpServletRequest request, Exception ex) {
        return   new ResponseEntity<Object>(
                "Aproblem occured due to: " + ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
