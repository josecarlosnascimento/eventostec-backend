package com.eventostec.api.controller.exception;

import lombok.Builder;

@Builder
public record ExceptionDTO(int code, String description) {}
