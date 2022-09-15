package ru.yandex.backend.dto;


import lombok.Builder;
import lombok.Value;
import ru.yandex.backend.validation.ValidItem;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Value
@Builder
public class ImportsRequest {

    List<Item> items;

    @NotNull(message = "Validation Failed")
    LocalDateTime updateDate;
}
