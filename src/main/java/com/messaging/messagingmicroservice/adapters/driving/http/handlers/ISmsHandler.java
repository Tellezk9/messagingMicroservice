package com.messaging.messagingmicroservice.adapters.driving.http.handlers;

import com.messaging.messagingmicroservice.adapters.driving.http.dto.ClientRequestDto;

public interface ISmsHandler {
    void sendSms(ClientRequestDto clientRequestDto);
}
