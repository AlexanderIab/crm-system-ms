package com.iablonski.crm.config.server;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ConfigServerApplicationTests {

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.config.server.git.uri}")
    private String gitUri;

    private TestRestTemplate restTemplate;
    private String baseUrl;

    @BeforeEach
    public void setUp() {
        restTemplate = new TestRestTemplate();
        baseUrl = "http://localhost:" + serverPort;
    }

    @Test
    void testServerIsUp() {
        String health = restTemplate.getForObject(baseUrl + "/actuator/health", String.class);
        assertEquals("{\"status\":\"UP\"}", health);
    }

    @Test
    public void testServerPort() {
        assertEquals(8888, serverPort);
    }

    @Test
    public void testGitUri() {
        assertEquals("https://github.com/AlexanderIab/crm-system-ms-properties", gitUri);
    }
}