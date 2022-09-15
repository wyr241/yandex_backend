package ru.yandex.backend.dto;

import ru.yandex.backend.domain.NodeType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Item {
    @NotBlank(message = "Validation Failed")
    String id;
    String url;
    String parentId;
    @NotNull
    NodeType type;
    Integer size;
}
