package com.eventostec.api.domain.event;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;

public record EventRequestDTO(String title,
		String description,
		@NotNull(message = "Preencha o campo Data") Long date,
		@NotNull(message = "Preencha o campo Cidade") String city,
		@NotNull(message = "Preencha o campo Estado") String state,
		@NotNull(message = "Preencha o campo Remoto") Boolean remote,
		@NotNull(message = "Preencha o campo URL") String eventUrl,
		MultipartFile image) {
}
