package ru.yandex.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.backend.domain.NodeEntity;
import ru.yandex.backend.repository.NodesRepository;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class FilesService {
    private final NodesRepository nodesRepository;

    public FilesService(NodesRepository nodesRepository) {
        this.nodesRepository = nodesRepository;
    }

    public void importNodes(List<NodeEntity> nodes) {
        nodesRepository.saveAll(nodes);
    }

    public void deleteAllById(String id) {
    }

    public void getAllById(String id) {
    }
}
