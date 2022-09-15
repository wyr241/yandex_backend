package ru.yandex.backend.validation;

import org.springframework.stereotype.Component;
import ru.yandex.backend.domain.NodeType;
import ru.yandex.backend.dto.Item;

import java.util.List;

@Component
public class ItemValidationService {

    public boolean isValid(List<Item> items) {
        for (Item item: items) {
            if (!isValid(item)) return false;
        }
        return true;
    }

    private boolean isValid(Item item) {
        // implement here

        if(item.getType() == NodeType.FOLDER){
            if(item.getUrl() != null) return false;
            if(item.getSize() != null) return false;
        } else if (item.getType() == NodeType.FILE) {
            if(item.getUrl().length() <= 255) return false;
            if(item.getSize() <= 0) return false;
        }
        return true;
    }
}
