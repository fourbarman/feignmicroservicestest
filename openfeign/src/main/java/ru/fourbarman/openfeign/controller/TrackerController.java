package ru.fourbarman.openfeign.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fourbarman.openfeign.model.Item;
import ru.fourbarman.openfeign.service.TrackerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/feign")
public class TrackerController {
    private final TrackerService trackerService;

    @PostMapping
    public Item save(@RequestBody Item item) {
        return trackerService.save(item);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update (@RequestParam int id, Item item) {
        return trackerService.update(id, item);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam int id) {
        trackerService.delete(id);
    }

    @GetMapping("/getById")
    public Item getById(@RequestParam int id) {
        return trackerService.findById(id);
    }

    @GetMapping("/getByName")
    public List<Item> getByName(@RequestParam String name) {
        return trackerService.findByName(name);
    }

    @GetMapping("/getAll")
    public List<Item> getAll() {
        return trackerService.findAll();
    }
}
