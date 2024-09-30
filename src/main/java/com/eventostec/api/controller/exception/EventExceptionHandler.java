package com.eventostec.api.controller.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EventExceptionHandler extends ResponseEntityExceptionHandler {
	
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<ExceptionDTO> errorList =  errorList(ex.getBindingResult());
        return handleExceptionInternal(ex, errorList, headers, status, request);
    }
    
    private List<ExceptionDTO> errorList(BindingResult bindingResult){
        List<ExceptionDTO> erros = new ArrayList<>();

        for (FieldError erro : bindingResult.getFieldErrors()) {
            erros.add(ExceptionDTO.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .description(erro.getDefaultMessage())
                    .build());
        }

        return erros;
    }

}
