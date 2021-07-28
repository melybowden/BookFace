package com.cygnus.bookface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class BookFaceController {
    @GetMapping("/")
    public String getRoot() {
        return "Hello world";
    }
}
