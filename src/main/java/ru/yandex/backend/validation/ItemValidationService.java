package ru.yandex.backend.validation;

import org.springframework.stereotype.Component;
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

        return false;
    }
}
