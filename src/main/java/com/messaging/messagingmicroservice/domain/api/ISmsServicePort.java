package com.messaging.messagingmicroservice.domain.api;

import com.messaging.messagingmicroservice.domain.model.Client;

public interface ISmsServicePort {

    void sendSms(Client client);
}
