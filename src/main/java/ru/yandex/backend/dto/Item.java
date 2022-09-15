package ru.yandex.backend.dto;

import lombok.Value;
import ru.yandex.backend.domain.NodeType;
import ru.yandex.backend.validation.ValidItem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
public class Item {
    @NotBlank(message = "Validation Failed")
    String id;

    String url;

    String parentId;

    @NotNull(message = "Validation Failed")
    NodeType type;

    Integer size;
}
