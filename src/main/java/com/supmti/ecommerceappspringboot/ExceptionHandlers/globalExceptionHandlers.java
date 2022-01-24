package com.supmti.ecommerceappspringboot.ExceptionHandlers;

import com.supmti.ecommerceappspringboot.Exceptions.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class globalExceptionHandlers {


    @ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String onAuthException(
            AuthException ex) {
        System.out.println("error---"+ex.getMessage());
        return  ex.getMessage();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    String onEntityNotFoundException(
            EntityNotFoundException ex) {
        System.out.println("error---"+ex.getMessage());
        return  ex.getMessage();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    Map<String,String> onConstraintValidationException(
            ConstraintViolationException ex) {
        System.out.println("error onConstraintValidationException---"+ex.getConstraintViolations());

        Map<String,String> errors=new HashMap<>();
                ex.getConstraintViolations()
                        .forEach(e->errors.put(e.getPropertyPath().toString(),e.getMessage()));
        return errors;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String,String> onMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        System.out.println("error onMethodArgumentNotValidException g---"+ex.getGlobalErrors());
        System.out.println("error onMethodArgumentNotValidException g---"+ex.getFieldErrors());

        Map<String,String> errors=new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(e->errors.put(e.getField(),e.getDefaultMessage()));

         ex.getBindingResult().getGlobalErrors()
                 .forEach(e->errors.put(e.getObjectName(),e.getDefaultMessage()));

        return errors;
    }



}
