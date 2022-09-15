package ru.yandex.backend.validation;

import org.springframework.util.StringUtils;
import ru.yandex.backend.domain.ItemEntity;
import ru.yandex.backend.domain.NodeType;
import ru.yandex.backend.dto.Item;
import ru.yandex.backend.repository.ItemRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.Optional;

// TODO: this is not working at the moment, need some investigation.
public class ValidItemConstraintValidator implements ConstraintValidator<ValidItem, Item> {
    private final ItemRepository itemRepository;

    public ValidItemConstraintValidator(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

//    @Override
    public void initialize(Item constraintAnnotation) {
        // Does nothing.
    }

    @Override
    public boolean isValid(Item value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        String ERR_MESSAGE = "Validation Failed";

        if (Objects.isNull(value)) {
            context.buildConstraintViolationWithTemplate(ERR_MESSAGE)
                    .addConstraintViolation();
            return false;
        }

        if (StringUtils.hasText(value.getParentId())) {
            Optional<ItemEntity> byId = itemRepository.findById(value.getParentId());
            if (byId.isPresent()) {
                ItemEntity nodeEntity = byId.get();
                if (nodeEntity.getType() != NodeType.FOLDER) {
                    context.buildConstraintViolationWithTemplate(ERR_MESSAGE)
                            .addConstraintViolation();
                    return false;
                }
            } else {
                context.buildConstraintViolationWithTemplate(ERR_MESSAGE)
                        .addConstraintViolation();
                return false;
            }
        }

        if (value.getType() == NodeType.FOLDER) {
            if (!Objects.isNull(value.getSize()) || !Objects.isNull(value.getUrl())) {
                context.buildConstraintViolationWithTemplate(ERR_MESSAGE)
                        .addConstraintViolation();
                return false;
            }
        }
        if (value.getType() == NodeType.FILE && value.getSize() <= 0) {
            context.buildConstraintViolationWithTemplate(ERR_MESSAGE)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
