package com.messaging.messagingmicroservice.domain.spi;

import com.messaging.messagingmicroservice.domain.model.Client;

public interface ISmsSenderPort {
    void sendSms(Client client, String message);
}
