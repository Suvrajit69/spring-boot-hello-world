package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

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

    @PostMapping("/upload")
public Map<String, String> uploadFile(@RequestParam("file") MultipartFile file) {
    Map<String, String> response = new HashMap<>();

    if (file.isEmpty()) {
        response.put("error", "No file uploaded");
        return response;
    }

    try {
        Path directoryPath = Paths.get("uploads");
        
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }

        Path path = directoryPath.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), path);

        response.put("fileName", file.getOriginalFilename());
    } catch (IOException e) {
        response.put("error", "File upload failed: " + e.getMessage());
    }

    return response;
}

}
