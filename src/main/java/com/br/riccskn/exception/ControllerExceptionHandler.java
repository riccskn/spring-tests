package com.br.riccskn.exception;

import com.br.riccskn.dto.output.ResponseOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResponseEntity<ResponseOutput> resolveException(ApiException exception) {

        ResponseOutput response = new ResponseOutput();

        response.setMessage(exception.getMessage());
        response.setSuccess(false);

        return new ResponseEntity<>(response,exception.getStatus());
    }



}
