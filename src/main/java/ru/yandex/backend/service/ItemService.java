package ru.yandex.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.backend.domain.ItemEntity;
import ru.yandex.backend.dto.ImportsRequest;
import ru.yandex.backend.dto.Item;
import ru.yandex.backend.mapper.ItemMapper;
import ru.yandex.backend.repository.ItemRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public void importItems(ImportsRequest importsRequest) {
        List<ItemEntity> items = new ArrayList<>();

        for (Item item : importsRequest.getItems()) {
            ItemEntity itemEntity = itemMapper.mapItemToItemEntity(item);
            itemEntity.setUpdate_date(importsRequest.getUpdateDate());

            if (item.getParentId() != null) {
                if (!itemRepository.existsById(item.getParentId())) {
                    throw new ResponseStatusException(
                            HttpStatus.INTERNAL_SERVER_ERROR,
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

    public void deleteAllById(String id) {
    }

    public void getAllById(String id) {
    }
}
