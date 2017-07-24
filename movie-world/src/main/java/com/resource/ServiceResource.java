package com.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/admin")
public class ServiceResource {

    @GetMapping("/status")
    public Map<String, String> status() {
        Map<String, String> statusMap = new HashMap<>();
        statusMap.put("name","Movie World");
        statusMap.put("message","It's Alive");
        return statusMap;
    }
}
