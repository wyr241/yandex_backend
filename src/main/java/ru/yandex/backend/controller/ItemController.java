package ru.yandex.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.backend.dto.ImportsRequest;
import ru.yandex.backend.dto.ImportsResponse;
import ru.yandex.backend.service.ItemService;
import ru.yandex.backend.validation.ItemValidationService;

import javax.validation.Valid;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/")//("/api/v1")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    private final ItemValidationService itemValidationService;


    @PostMapping("/imports")
    public ResponseEntity<ImportsResponse> importElements(@Valid @RequestBody ImportsRequest importsRequest) {
        if (!itemValidationService.isValid(importsRequest.getItems())) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Validation Failed"
            );
        }

        itemService.importItems(importsRequest);

        return ResponseEntity.ok().build();
    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteNodeById(@PathVariable String id,
//                               @RequestParam(name = "date", required = false, defaultValue = "") LocalDateTime date) {
//        filesService.deleteAllById(id);
//    }
//
//    @GetMapping("/nodes/{id}")
//    public void getAllNodes(@PathVariable String id) {
//        filesService.getAllById(id);
//    }

//    @GetMapping("/updates")
//    public void getFileUpdate(){
//
//    }
//
//    @GetMapping("/node/{id}/history")
//    public void getAllNodesHistory(@PathVariable String id) {
//    }
}
