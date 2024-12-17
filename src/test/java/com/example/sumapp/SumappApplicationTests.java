package com.example.sumapp.controllers;

import com.example.sumapp.SumappApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SumappApplication.class)
@AutoConfigureMockMvc  // Configura o MockMvc automaticamente
class SumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSumEndpoint() throws Exception {
        // Cria o JSON de entrada
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("values", new int[]{1, 56, 39});

        // Realiza a requisição POST e verifica a resposta
        mockMvc.perform(post("/api/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(96));
    }
}
