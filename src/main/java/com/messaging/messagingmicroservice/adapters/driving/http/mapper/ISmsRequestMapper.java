package com.messaging.messagingmicroservice.adapters.driving.http.mapper;

import com.messaging.messagingmicroservice.adapters.driving.http.dto.ClientRequestDto;
import com.messaging.messagingmicroservice.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISmsRequestMapper {
    Client toClient(ClientRequestDto clientRequestDto);
}
