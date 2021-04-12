package br.com.ftech.forum.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TopicosControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@WithMockUser(value = "spring")
	@Test
	public void deveBuscarTopicos() throws Exception {
		mockMvc.perform(get("/topicos")).andExpect(status().isOk());
	}

	@WithMockUser(value = "spring")
	@Test
	public void deveCadastrarUmTopico() throws Exception {

		JSONObject form = new JSONObject();
		form.put("titulo", "teste");
		form.put("mensagem", "testando o cadastro");
		form.put("nomeCurso", "spring testes");

		mockMvc.perform(MockMvcRequestBuilders.post("/topicos").contentType(MediaType.APPLICATION_JSON)
				.content(form.toString()).header("Content-Type", "application/json"))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));
	}

	@WithMockUser(value = "spring")
	@Test
	public void deveBuscarTopicoCurso() throws Exception {
		mockMvc.perform(get("/topicos/1")).andExpect(status().isOk());
	}
	
	@WithMockUser(value = "spring")
	@Test
	public void deveAtualizarUmTopico() throws Exception {

		JSONObject form = new JSONObject();
		form.put("titulo", "teste2");
		form.put("mensagem", "atualizando um cadastro");

		mockMvc.perform(MockMvcRequestBuilders.put("/topicos/1").contentType(MediaType.APPLICATION_JSON)
				.content(form.toString()).header("Content-Type", "application/json"))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
	}
	
	@WithMockUser(value = "spring")
	@Test
	public void naoDeveAtualizarUmTopico() throws Exception {
		JSONObject form = new JSONObject();
		form.put("titulo", "teste2");
		form.put("mensagem", "atualizando um cadastro");

		mockMvc.perform(MockMvcRequestBuilders.put("/topicos/20").contentType(MediaType.APPLICATION_JSON)
				.content(form.toString()).header("Content-Type", "application/json"))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.NOT_FOUND.value()));
	}
	
		
	@WithMockUser(value = "spring")
	@Test
	public void deveExcluirUmTopico() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/topicos/3"))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
	}

}
