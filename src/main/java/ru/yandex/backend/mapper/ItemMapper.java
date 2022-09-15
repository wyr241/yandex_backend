package ru.yandex.backend.mapper;

import org.springframework.stereotype.Component;
import ru.yandex.backend.domain.ItemEntity;
import ru.yandex.backend.dto.GetItemResponse;
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

    public GetItemResponse mapItemToGetItemResponse(ItemEntity itemEntity) {
        GetItemResponse getItemResponse = new GetItemResponse();
        getItemResponse.setId(itemEntity.getId());
        getItemResponse.setUrl(itemEntity.getUrl());
        getItemResponse.setType(itemEntity.getType());
        getItemResponse.setSize(itemEntity.getSize());

        return getItemResponse;
    }

}
