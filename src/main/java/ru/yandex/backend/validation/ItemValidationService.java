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
        Set<String> ids = new HashSet<String>();
        for (Item item: items) {
            if(ids.contains(item.getId())) return false;
            else ids.add(item.getId());

            if (!isValid(item)) return false;
        }
        return true;
    }

    private boolean isValid(Item item) {
        // implement here
        if(item.getId() == null) return false;
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
