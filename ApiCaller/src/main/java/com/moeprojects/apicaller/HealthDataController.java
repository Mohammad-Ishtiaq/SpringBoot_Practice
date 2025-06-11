package com.moeprojects.apicaller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HealthDataController {

    private final String API_URL = "https://www.healthit.gov/data/open-api?source=Surescripts_County_04-2014.csv";

    @GetMapping("/api/button1")
    public ResponseEntity<String> getHealthData() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0");  // Mimic a browser

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity, String.class);

        return response;
    }
}