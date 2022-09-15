package ru.yandex.backend.validation;

import org.springframework.stereotype.Component;
import ru.yandex.backend.domain.NodeType;
import ru.yandex.backend.dto.Item;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ItemValidationService {

    public boolean isValid(List<Item> items) {
        Set<String> ids = new HashSet<>();
        for (Item item : items) {
            if (ids.contains(item.getId())) return false;
            else ids.add(item.getId());

            if (!isValid(item)) return false;
        }
        return true;
    }

    private boolean isValid(Item item) {
        if (item.getType() == NodeType.FOLDER) {
            if (item.getUrl() != null || item.getSize() != null) return false;
        } else if (item.getType() == NodeType.FILE) {
            if (item.getUrl().length() <= 255 || item.getSize() <= 0) return false;
        }
        return true;
    }
}
