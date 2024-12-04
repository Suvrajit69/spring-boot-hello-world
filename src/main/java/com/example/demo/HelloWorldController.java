package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    // GET Endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    
    @PostMapping("/create")
    public Map<String, Object> createResource(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Resource created successfully");
        response.put("data", request); 
        return response;
    }


    @PatchMapping("/update")
    public Map<String, Object> updateResource(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Resource updated successfully");
        response.put("updatedFields", request); 
        return response;
    }

    @PutMapping("/replace")
    public Map<String, Object> replaceResource(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Resource replaced successfully");
        response.put("newData", request); 
        return response;
    }
}
