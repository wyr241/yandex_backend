package ru.yandex.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.backend.dto.ImportsRequest;
import ru.yandex.backend.dto.ImportsResponse;
import ru.yandex.backend.service.FilesService;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/")//("/api/v1")
@RequiredArgsConstructor
public class YADiskController {
    private final FilesService filesService;

    @PostMapping("/imports")
    public ResponseEntity<ImportsResponse> importElements(@Valid @RequestBody ImportsRequest importsRequest) {
//        filesService.importNodes();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNodeById(@PathVariable String id,
                               @RequestParam(name = "date", required = false, defaultValue = "") LocalDateTime date) {
        filesService.deleteAllById(id);
    }

    @GetMapping("/nodes/{id}")
    public void getAllNodes(@PathVariable String id) {
        filesService.getAllById(id);
    }

//    @GetMapping("/updates")
//    public void getFileUpdate(){
//
//    }
//
//    @GetMapping("/node/{id}/history")
//    public void getAllNodesHistory(@PathVariable String id) {
//    }
}
