package com.messaging.messagingmicroservice.adapters.driving.http.handlers.impl;

import com.messaging.messagingmicroservice.adapters.driving.http.dto.ClientRequestDto;
import com.messaging.messagingmicroservice.adapters.driving.http.handlers.ISmsHandler;
import com.messaging.messagingmicroservice.adapters.driving.http.mapper.ISmsRequestMapper;
import com.messaging.messagingmicroservice.domain.api.ISmsServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsHandlerImpl implements ISmsHandler {
    private final ISmsServicePort smsServicePort;
    private final ISmsRequestMapper smsRequestMapper;

    @Override
    public void sendSms(ClientRequestDto clientRequestDto) {
        smsServicePort.sendSms(smsRequestMapper.toClient(clientRequestDto));
    }
}
