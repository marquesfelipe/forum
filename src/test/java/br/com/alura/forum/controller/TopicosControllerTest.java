package br.com.alura.forum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import br.com.alura.forum.ForumApplication;

@SpringBootTest(classes = ForumApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TopicosControllerTest {
	
	@LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
	
	/*
	 * @Sql({ "schema.sql", "data.sql" })
	 * 
	 * @Test public void testAllEmployees() {
	 * assertTrue(this.restTemplate.getForObject("http://localhost:" + port +
	 * "/topicos", Employees.class) .getEmployeeList().size() == 3); }
	 */

}
