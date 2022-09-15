package ru.yandex.backend.dto;


import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;


@Value
@Builder
public class ImportsRequest {
    Set<Item> items;

    @NotNull
    LocalDateTime updateDate;
}
