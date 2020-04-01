package com.youtube.labs.youtubelabs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/hello")
    public ResponseEntity test () {
        Map<String,String> data = new HashMap<>();
        data.put("hello","World");

        return ResponseEntity.ok(data);
    }
}
