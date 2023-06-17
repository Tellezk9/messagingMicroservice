package com.messaging.messagingmicroservice.domain.service;

import com.messaging.messagingmicroservice.domain.exceptions.EmptyFieldFoundException;
import com.messaging.messagingmicroservice.domain.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SmsServiceTest {
    private SmsService smsService;

    @BeforeEach
    void setUp() {
        smsService = new SmsService();
    }

    @Test
    void allFieldsFilled() {
        Client client = new Client(1L,2L, "testName", "string", 4, "+439094230412", "string");
        assertTrue(() -> smsService.allFieldsFilled(client));
    }

    @ParameterizedTest
    @CsvSource({
            ",2,testName, string, 4, +439094230412, string",
            "1,,testName, string, 4, +439094230412, string",
            "1,2, ,string, 4, +439094230412, string",
            "1,2,testName, , 4, +439094230412, string",
            "1,2,testName, string, , +439094230412, string",
            "1,2,testName, string, 4, , string",
            "1,2,testName, string, 4, +439094230412, ",
    })
    void allFieldsWithoutParams(Long id,Long idOrder, String name, String lastName, Integer dniNumber, String phone, String mail) {

        Client client = new Client(id,idOrder, name, lastName, dniNumber, phone, mail);

        assertThrows(EmptyFieldFoundException.class, () -> smsService.allFieldsFilled(client));
    }

}