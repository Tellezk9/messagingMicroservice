package com.messaging.messagingmicroservice.domain.service;

import com.messaging.messagingmicroservice.domain.exceptions.EmptyFieldFoundException;
import com.messaging.messagingmicroservice.domain.model.Client;

public class SmsService {
    public boolean allFieldsFilled(Client client) {
        if (
                (client.getId() == null || client.getId() < 0) ||
                        (client.getSecurityPin() == null || client.getSecurityPin() < 0 ||
                        (client.getName() == null || client.getName().isEmpty()) ||
                        (client.getLastName() == null || client.getLastName().isEmpty()) ||
                        (client.getDniNumber() == null || client.getDniNumber() < 0) ||
                        (client.getPhone() == null || client.getPhone().isEmpty()) ||
                        (client.getMail() == null || client.getMail().isEmpty())
                )
        ) {
            throw new EmptyFieldFoundException();
        }
        return true;
    }
}
