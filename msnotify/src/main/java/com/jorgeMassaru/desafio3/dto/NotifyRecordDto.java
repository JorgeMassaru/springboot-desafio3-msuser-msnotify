package com.jorgeMassaru.desafio3.dto;

import java.util.UUID;

public record NotifyRecordDto(UUID userId,
                              String notifyTo,
                              String subject,
                              String text) {
}
