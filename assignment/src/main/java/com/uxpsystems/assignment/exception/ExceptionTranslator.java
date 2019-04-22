package com.uxpsystems.assignment.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class ExceptionTranslator{

    private final Logger log = LoggerFactory.getLogger(ExceptionTranslator.class);

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus // or @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<ErrorDTO> processMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
        log.error("Method Not Supported");
        return new ResponseEntity<ErrorDTO>(new ErrorDTO(HttpStatus.METHOD_NOT_ALLOWED, "Method Not Supported", ex.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(ResourcesNotFoundException.class)
    @ResponseBody
    @ResponseStatus
    public ResponseEntity<ErrorDTO> processResourcesNotFoundException(ResourcesNotFoundException ex){
        log.error("Resources Not FoundE");
        return new ResponseEntity<ErrorDTO>(new ErrorDTO(HttpStatus.NOT_FOUND, "Resources Not FoundE", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus
    public ResponseEntity<ErrorDTO> processMethodNotSupportedException(MethodArgumentNotValidException ex){
        log.error("Method Argument Not Valid");
        return new ResponseEntity<ErrorDTO>(new ErrorDTO(HttpStatus.BAD_REQUEST, "Method Argument Not Valid", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
