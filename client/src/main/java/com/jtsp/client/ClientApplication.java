package com.jtsp.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
@Slf4j
public class ClientApplication {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVER_API = "http://localhost:8081/server";

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @GetMapping("/client/{interval}")
    public ResponseEntity<String> sendRequestToServer(@PathVariable Integer interval) {
        for (int i = 0; i < 10; i++) {
            scheduler.schedule(() -> {
                restTemplate.getForObject(SERVER_API, String.class);
            }, i * interval, TimeUnit.MILLISECONDS);
        }
        return ResponseEntity.ok("send success");
    }
}
