package com.assignment.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexApi {

    @PostMapping("/assignment")
    public String find() {
        return "hello";
    }

}
