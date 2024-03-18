package com.iablonski.crm.eureka.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlannerEurekaServerApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Value("${server.port}")
	private int serverPort;

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${eureka.client.register-with-eureka}")
	private boolean registerWithEureka;

	@Value("${eureka.client.fetch-registry}")
	private boolean fetchRegistry;

	@Value("${spring.cloud.config.uri}")
	private String configServerUri;

	@Test
	void contextLoads() {
		String health = restTemplate.getForObject("/actuator/health", String.class);
		assertEquals("{\"status\":\"UP\"}", health);
	}

	@Test
	void portConfigurationTest() {
		assertEquals(8761, serverPort);
	}

	@Test
	void applicationNameTest() {
		assertEquals("eureka-server", applicationName);
	}

	@Test
	void configServerUriTest() {
		assertEquals("http://localhost:8888", configServerUri);
	}

	@Test
	void eurekaConfigurationTest() {
		assertFalse(registerWithEureka);
		assertFalse(fetchRegistry);
	}
}