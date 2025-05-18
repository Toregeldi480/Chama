package com.chama.Chama.janitor;

import java.util.Collection;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/janitor")
public class JanitorController {
  @Autowired
  private JanitorService janitorService;

  @GetMapping()
  public ResponseEntity<Collection<Janitor>> getAllJanitors(@RequestHeader("Authorization") String token) {
    Collection<Janitor> janitors = janitorService.getJanitors();
    return ResponseEntity.status(HttpStatus.OK).body(janitors);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Janitor> updateJanitor(@RequestHeader("Authorization") String token, @PathVariable Long id, @RequestBody Janitor janitor) {
    Janitor updatedUser = janitorService.updateJanitor(id, janitor);
    return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteJanitor(@RequestHeader("Authorization") String token, @PathVariable Long id) {
    janitorService.deleteJanitor(id);
    return ResponseEntity.status(HttpStatus.OK).body("Deleted user for id:" + id);
  }
}
