package ru.yandex.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.backend.dto.GetItemResponse;
import ru.yandex.backend.dto.ImportsRequest;
import ru.yandex.backend.service.ItemService;
import ru.yandex.backend.validation.ItemValidationService;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    private final ItemValidationService itemValidationService;


    @PostMapping("/imports")
    public void importElements(@Valid @RequestBody ImportsRequest importsRequest) {
        if (!itemValidationService.isValid(importsRequest.getItems())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Validation Failed"
            );
        }

        itemService.importItems(importsRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNodeById(@PathVariable String id,
                               @RequestParam(name = "date", required = false, defaultValue = "") LocalDateTime date) {
        itemService.deleteById(id);
    }

    @GetMapping("/nodes/{id}")
    public GetItemResponse getItem(@PathVariable String id) {
        return itemService.getItem(id);
    }

//    @GetMapping("/updates")
//    public void getItemUpdate(){
//
//    }
//
//    @GetMapping("/node/{id}/history")
//    public void getAllItemsHistory(@PathVariable String id) {
//    }
}
