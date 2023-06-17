package com.messaging.messagingmicroservice.adapters.driving.http.controller;

import com.messaging.messagingmicroservice.adapters.driving.http.dto.ClientRequestDto;
import com.messaging.messagingmicroservice.adapters.driving.http.handlers.ISmsHandler;
import com.messaging.messagingmicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class SmsRestController {
    private final ISmsHandler smsHandler;

    @Operation(summary = "Send a sms notification",
            responses = {
                    @ApiResponse(responseCode = "200", description = "sms sent successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Error to make the process",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "406", description = "The sms notification could not be sent.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping()
    public ResponseEntity<Map<String,String>> sendSms(@Valid @RequestBody ClientRequestDto clientRequestDto){
        smsHandler.sendSms(clientRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.SENT_SUCCESSFULLY_MESSAGE));
    }
}
