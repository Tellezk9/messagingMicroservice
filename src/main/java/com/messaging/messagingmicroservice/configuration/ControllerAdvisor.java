package com.messaging.messagingmicroservice.configuration;

import com.messaging.messagingmicroservice.adapters.driver.twilio.exceptions.ErrorToSendSmsException;
import com.messaging.messagingmicroservice.domain.exceptions.EmptyFieldFoundException;
import com.messaging.messagingmicroservice.domain.exceptions.InvalidFormatMailException;
import com.messaging.messagingmicroservice.domain.exceptions.InvalidPhoneException;
import com.messaging.messagingmicroservice.domain.exceptions.InvalidPhoneLengthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.messaging.messagingmicroservice.configuration.Constants.*;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError fieldError) {
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidFormatMailException.class)
    public ResponseEntity<Map<String,String>> invalidFormatMailException(
            InvalidFormatMailException invalidFormatMailException
    ){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_FORMAT_EMAIL_MESSAGE));
    }

    @ExceptionHandler(ErrorToSendSmsException.class)
    public ResponseEntity<Map<String, String>> errorToSendSmsException(
            ErrorToSendSmsException errorToSendSmsException) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, SMS_NOTIFICATION_COULD_NOT_SEND_MESSAGE));
    }

    @ExceptionHandler(InvalidPhoneLengthException.class)
    public ResponseEntity<Map<String,String>> invalidPhoneLengthException(
            InvalidPhoneLengthException invalidPhoneLengthException
    ){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_PHONE_LENGTH_MESSAGE));
    }

    @ExceptionHandler(EmptyFieldFoundException.class)
    public ResponseEntity<Map<String, String>> emptyFieldFoundException(
            EmptyFieldFoundException emptyFieldFoundException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, EMPTY_FIELD_FOUND_MESSAGE));
    }
    @ExceptionHandler(InvalidPhoneException.class)
    public ResponseEntity<Map<String,String>> invalidPhoneException(
            InvalidPhoneException invalidPhoneException
    ){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_PHONE_MESSAGE));
    }
}
