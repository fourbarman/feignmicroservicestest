package ru.fourbarman.openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fourbarman.openfeign.model.Item;

import java.util.List;

@FeignClient(name = "tracker", url = "${source-api-url}")
public interface TrackerProxy {
    @PostMapping
    Item save(@RequestBody Item item);

    @PutMapping
    ResponseEntity<HttpStatus> update(@RequestParam int id, @RequestBody Item item);

    @DeleteMapping
    void delete(@RequestParam int id);

    @GetMapping("/getById")
    Item getById(@RequestParam int id);

    @GetMapping("/getByName")
    List<Item> getByName(@RequestParam String name);

    @GetMapping("/getAll")
    List<Item> getAll();
}
