package ru.yandex.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.backend.domain.ItemEntity;
import ru.yandex.backend.dto.GetItemResponse;
import ru.yandex.backend.dto.ImportsRequest;
import ru.yandex.backend.dto.Item;
import ru.yandex.backend.mapper.ItemMapper;
import ru.yandex.backend.repository.ItemRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Transactional
    public void importItems(ImportsRequest importsRequest) {
        List<ItemEntity> items = new ArrayList<>();

        for (Item item : importsRequest.getItems()) {
            ItemEntity itemEntity = itemMapper.mapItemToItemEntity(item);
            itemEntity.setUpdate_date(importsRequest.getUpdateDate());

            if (item.getParentId() != null) {
                if (!itemRepository.existsById(item.getParentId())) {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Validation Failed"
                    );
                }

                // this not correct actually..need to rewrite
                ItemEntity parent = itemRepository.findById(item.getParentId()).get();

                itemEntity.setParent(parent);
            }

            itemRepository.save(itemEntity);
        }
    }

    public void deleteById(String id) {
        itemRepository.deleteById(id);
    }

    public GetItemResponse getItem(String id) {
        if (id == null || !itemRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Validation Failed"
            );
        }

        // this not correct actually..need to rewrite
        ItemEntity itemEntity = itemRepository.findById(id).get();

        GetItemResponse getItemResponse = itemMapper.mapItemToGetItemResponse(itemEntity);

        return getItemResponse;
    }
}
