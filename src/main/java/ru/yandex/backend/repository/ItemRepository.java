package ru.yandex.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.backend.domain.ItemEntity;

import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {
    Optional<ItemEntity> findById(String id);
}
