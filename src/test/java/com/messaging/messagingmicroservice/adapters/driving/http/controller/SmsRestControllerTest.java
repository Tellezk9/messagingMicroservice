package com.messaging.messagingmicroservice.adapters.driving.http.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.messaging.messagingmicroservice.adapters.driving.http.dto.ClientRequestDto;
import com.messaging.messagingmicroservice.adapters.driving.http.handlers.ISmsHandler;
import com.messaging.messagingmicroservice.configuration.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class SmsRestControllerTest {
    @Mock
    private ISmsHandler smsHandler;
    @InjectMocks
    private SmsRestController smsRestController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(smsRestController).build();
    }

    @Test
    void sendSms() throws Exception {
        MockHttpServletResponse response = new MockHttpServletResponse();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ClientRequestDto clientRequestDto = new ClientRequestDto(1L,2L, "testName", "testLastName", 123, "+573102370394", "2020/01/01", "test@email.com", "password");
        doNothing().when(smsHandler).sendSms(Mockito.any(ClientRequestDto.class));

        mockMvc.perform(post("/sms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(clientRequestDto))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(Constants.SENT_SUCCESSFULLY_MESSAGE));
    }
}