package com.energy.energy.api.controllers;

import com.energy.energy.api.models.dto.BoxDTO;
import com.energy.energy.api.models.entities.Box;
import com.energy.energy.api.services.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boxes")
public class BoxController {

    @Autowired
    private BoxService boxService;

    @PostMapping
    public ResponseEntity<BoxDTO> create(@RequestBody Box box) {
        BoxDTO createdBox = boxService.create(box);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBox);
    }

    @GetMapping
    public ResponseEntity<Page<BoxDTO>> getBoxes(
            @RequestParam(required = false) Long id,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        return ResponseEntity.ok(boxService.getBoxes(id, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoxDTO> update(@PathVariable Long id, @RequestBody Box box) {
        return boxService.update(id, box)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (boxService.delete(id)) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.notFound().build();      // 404 Not Found
    }

}