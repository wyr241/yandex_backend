package ru.yandex.backend.dto;

import lombok.Data;
import ru.yandex.backend.domain.NodeType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetItemResponse {
    String id;

    String url;

    String parentId;

    NodeType type;

    Integer size;

    List<Item> children;
}
