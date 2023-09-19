package com.vtxlab.demo.demoresttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Hamcrest
// Junit5 = jupiter -> @Mock, @InjectMock, Mockito
// Spring Test Framework -> @WebMvcTest
// what is @SpringBootTest?

// I am going to test the Server Start Process, with dependency checking
@SpringBootTest // With a complete context
// mvn test -> Simulate App Server Start & Bean Injection on Context
class DemoResttemplateApplicationTests {

	@Test
	void contextLoads() { // Test Server Start

	}

}
