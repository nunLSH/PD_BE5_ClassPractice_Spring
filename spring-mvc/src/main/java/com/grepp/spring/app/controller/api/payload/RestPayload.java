package com.grepp.spring.app.controller.api.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.OffsetDateTime;
import org.springframework.web.bind.annotation.InitBinder;

public record RestPayload(
    Integer id,
    String email,
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    OffsetDateTime lastAccess,
    Long lastAccessTimestamp
) {

}
