package ru.yandex.backend.mapper;

import org.springframework.stereotype.Component;
import ru.yandex.backend.domain.ItemEntity;
import ru.yandex.backend.dto.Item;

@Component
public class ItemMapper {

    public ItemEntity mapItemToItemEntity(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(item.getId());
        itemEntity.setUrl(item.getUrl());
        itemEntity.setType(item.getType());
        itemEntity.setSize(item.getSize());

        return itemEntity;
    }
}
