package br.com.ueder.listapresenca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorUtil {

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<Erro> handleRegraNegocioException(RegraNegocioException ex) {
        Erro erro = new Erro(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Erro> handleObjectNotFoundException(ObjectNotFoundException ex) {
        Erro erro = new Erro(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Erro> handleException(Exception ex) {
        Erro erro = new Erro(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}
