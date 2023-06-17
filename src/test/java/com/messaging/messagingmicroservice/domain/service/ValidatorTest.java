package com.messaging.messagingmicroservice.domain.service;

import com.messaging.messagingmicroservice.domain.exceptions.EmptyFieldFoundException;
import com.messaging.messagingmicroservice.domain.exceptions.InvalidFormatMailException;
import com.messaging.messagingmicroservice.domain.exceptions.InvalidPhoneException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }


    @Test
    @DisplayName("when the phone is empty")
    void isValidPhoneEmpty() {
        assertThrows(EmptyFieldFoundException.class, () -> validator.isValidPhone(""));
    }

    @Test
    @DisplayName("When the phone does not have the plus (+) character")
    void isValidPhoneWithoutCharacter() {
        assertThrows(InvalidPhoneException.class, () -> validator.isValidPhone("123456789012"));
    }

    @Test
    void isValidMail() {
        assertTrue(validator.isValidMail("test@gmail.com"));
    }

    @Test
    @DisplayName("When the Mail does not have the @ character or (.)")
    void isNotValidMail() {
        assertThrows(InvalidFormatMailException.class, () -> validator.isValidMail("test@icom"));
        assertThrows(InvalidFormatMailException.class, () -> validator.isValidMail("testi.com"));
        assertThrows(InvalidFormatMailException.class, () -> validator.isValidMail("testicom"));
    }

    @Test
    @DisplayName("when the mail is empty")
    void isEmptyMail() {
        assertThrows(EmptyFieldFoundException.class, () -> validator.isValidMail(""));
    }


}