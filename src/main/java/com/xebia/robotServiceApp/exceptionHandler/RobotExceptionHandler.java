package com.xebia.robotServiceApp.exceptionHandler;

import com.xebia.robotServiceApp.domain.RobotResponse;
import com.xebia.robotServiceApp.exception.ProductException;
import com.xebia.robotServiceApp.exception.RobotException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RobotExceptionHandler {

    @ExceptionHandler( value= {RobotException.class})
    public ResponseEntity<RobotResponse> handle (Exception ex, WebRequest request){
        RobotResponse response = new RobotResponse();
        response.setExceptionMessage(ex.getMessage());
        return ResponseEntity.ok(response);
    }
 }
