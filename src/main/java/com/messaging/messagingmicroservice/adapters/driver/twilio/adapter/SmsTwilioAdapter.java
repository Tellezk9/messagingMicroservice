package com.messaging.messagingmicroservice.adapters.driver.twilio.adapter;

import com.messaging.messagingmicroservice.adapters.driver.twilio.exceptions.ErrorToSendSmsException;
import com.messaging.messagingmicroservice.domain.model.Client;
import com.messaging.messagingmicroservice.domain.spi.ISmsSenderPort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsTwilioAdapter implements ISmsSenderPort {

    @Value("${app.messaging.twilio.Account_SID}")
    String accountSid;
    @Value("${app.messaging.twilio.Auth_token}")
    String authToken;
    @Value("${app.messaging.twilio.Service_SID}")
    String serviceSid;

    @Override
    public void sendSms(Client client, String message) {
        try {
            Twilio.init(accountSid, authToken);
            MessageCreator messageCreator = Message.creator(
                    new PhoneNumber(client.getPhone()),serviceSid,message
            );
            messageCreator.create();
        }catch (Exception ex){
            throw new ErrorToSendSmsException();
        }
    }
}
