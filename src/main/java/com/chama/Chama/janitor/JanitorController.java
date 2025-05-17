package com.chama.Chama.janitor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/janitor")
public class JanitorController {
  @Autowired
  private JanitorService janitorService;

  @PostMapping
  public ResponseEntity<JanitorDto> addNewJanitor(@RequestBody JanitorDto janitorDto) {
    JanitorDto savedUser = janitorService.createJanitor(janitorDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
  }
}
