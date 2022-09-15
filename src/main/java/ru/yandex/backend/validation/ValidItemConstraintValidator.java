package ru.yandex.backend.validation;

import org.springframework.util.StringUtils;
import ru.yandex.backend.domain.NodeEntity;
import ru.yandex.backend.domain.NodeType;
import ru.yandex.backend.dto.Item;
import ru.yandex.backend.repository.NodesRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.Optional;

public class ValidItemConstraintValidator implements ConstraintValidator<ValidItem, Item> {
    private final NodesRepository nodesRepository;

    public ValidItemConstraintValidator(NodesRepository nodesRepository) {
        this.nodesRepository = nodesRepository;
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

//        if (StringUtils.hasText(value.getParentId())) {
//            Optional<NodeEntity> byId = nodesRepository.findById(value.getParentId());
//            if (byId.isPresent()) {
//                NodeEntity nodeEntity = byId.get();
//                if (nodeEntity.getType() != NodeType.FOLDER) {
//                    context.buildConstraintViolationWithTemplate(ERR_MESSAGE)
//                            .addConstraintViolation();
//                    return false;
//                }
//            } else {
//                context.buildConstraintViolationWithTemplate(ERR_MESSAGE)
//                        .addConstraintViolation();
//                return false;
//            }
//        }
//
//        if (value.getType() == NodeType.FOLDER) {
//            if (!Objects.isNull(value.getSize()) || !Objects.isNull(value.getUrl())) {
//                context.buildConstraintViolationWithTemplate(ERR_MESSAGE)
//                        .addConstraintViolation();
//                return false;
//            }
//        }
//        if (value.getType() == NodeType.FILE && value.getSize() <= 0) {
//            context.buildConstraintViolationWithTemplate(ERR_MESSAGE)
//                    .addConstraintViolation();
//            return false;
//        }

        return true;
    }
}
