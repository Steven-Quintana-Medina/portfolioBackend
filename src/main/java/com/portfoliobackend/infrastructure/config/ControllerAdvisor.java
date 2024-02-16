package com.portfoliobackend.infrastructure.config;

import com.portfoliobackend.services.exceptions.ProjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

import static com.portfoliobackend.infrastructure.config.Constants.PROJECT_NOT_FOUND;
import static com.portfoliobackend.infrastructure.config.Constants.RESPONSE_ERROR_MESSAGE_KEY;

@ControllerAdvice
public class ControllerAdvisor {
@ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlerProjectNotFoundException(){
    return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, PROJECT_NOT_FOUND));
}

}
