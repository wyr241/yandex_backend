package ru.yandex.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ImportsResponse {
    @NotNull
    Integer code;

    @NotNull
    String message;
}
