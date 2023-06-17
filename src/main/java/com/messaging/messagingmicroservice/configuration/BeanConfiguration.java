package com.messaging.messagingmicroservice.configuration;

import com.messaging.messagingmicroservice.adapters.driver.twilio.adapter.SmsTwilioAdapter;
import com.messaging.messagingmicroservice.domain.api.ISmsServicePort;
import com.messaging.messagingmicroservice.domain.spi.ISmsSenderPort;
import com.messaging.messagingmicroservice.domain.usecase.SmsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    @Bean
    public ISmsServicePort smsServicePort(){
        return new SmsUseCase(smsSenderPort());
    }

    @Bean
    public ISmsSenderPort smsSenderPort(){
        return new SmsTwilioAdapter();
    }
}
