package com.messaging.messagingmicroservice.domain.usecase;

import com.messaging.messagingmicroservice.domain.model.Client;
import com.messaging.messagingmicroservice.domain.api.ISmsServicePort;
import com.messaging.messagingmicroservice.domain.service.SmsService;
import com.messaging.messagingmicroservice.domain.service.Validator;
import com.messaging.messagingmicroservice.domain.spi.ISmsSenderPort;

public class SmsUseCase implements ISmsServicePort {
    private final ISmsSenderPort smsSenderPort;
    private final SmsService smsService;
    private final Validator validator;

    public SmsUseCase(ISmsSenderPort smsSenderPort) {
        this.smsSenderPort = smsSenderPort;
        this.smsService = new SmsService();
        this.validator = new Validator();
    }

    public void sendSms(Client client) {
        smsService.allFieldsFilled(client);
        validator.isValidPhone(client.getPhone());
        validator.isValidMail(client.getMail());

        String message = "Hello " + client.getName() + ", We would like to inform you that your order is ready for pickup.\n your code is: "+ client.getSecurityPin();
        smsSenderPort.sendSms(client, message);
    }
}
