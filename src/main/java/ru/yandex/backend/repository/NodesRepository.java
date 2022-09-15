package ru.yandex.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.backend.domain.NodeEntity;

@Repository
public interface NodesRepository extends JpaRepository<NodeEntity, String> {
}
