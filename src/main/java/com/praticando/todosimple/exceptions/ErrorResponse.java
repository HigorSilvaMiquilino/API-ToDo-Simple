package com.praticando.todosimple.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {
    private final int status;
    private final String message;
    private String stackTrace;
    private List<ValidationErrors> errors;

    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class ValidationErrors {
        private final String field; //trace
        private final String message; // mensagem do erro
    }


    public void addValidationError(String field, String message){
            if(Objects.isNull(errors)){
                this.errors = new ArrayList<>();
            }
            this.errors.add(new ValidationErrors(field,message));
    }

    
}
