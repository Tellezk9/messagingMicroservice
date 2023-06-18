package com.messaging.messagingmicroservice.domain.usecase;

import com.messaging.messagingmicroservice.domain.model.Client;
import com.messaging.messagingmicroservice.domain.spi.ISmsSenderPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SmsUseCaseTest {
    @Mock
    private ISmsSenderPort smsSenderPort;
    @InjectMocks
    private SmsUseCase smsUseCase;

    @Test
    void sendSms() {
        Client client = new Client(1L, 2L, "testName", "testLastName", 123, "+573102370394", "test@email.com");
        String message = "Hello " + client.getName() + ", We would like to inform you that your order is ready for pickup.\n" +
                " your code is: " + client.getSecurityPin();

        doNothing().when(smsSenderPort).sendSms(client, message);

        smsUseCase.sendSms(client);

        verify(smsSenderPort, times(1)).sendSms(client, message);
    }
}