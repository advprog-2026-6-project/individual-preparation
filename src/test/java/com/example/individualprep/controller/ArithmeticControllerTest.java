package com.example.individualprep.controller;

import com.example.individualprep.service.ArithmeticUtility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArithmeticController.class)
class ArithmeticControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ArithmeticUtility arithmeticUtility;

    @Test
    void testAdd() throws Exception {
        when(arithmeticUtility.add(2.0, 3.0)).thenReturn(5.0);

        mockMvc.perform(post("/api/arithmetic/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"operand1\": 2.0, \"operand2\": 3.0}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value(5.0));
    }

    @Test
    void testSubtract() throws Exception {
        when(arithmeticUtility.subtract(5.0, 3.0)).thenReturn(2.0);

        mockMvc.perform(post("/api/arithmetic/subtract")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"operand1\": 5.0, \"operand2\": 3.0}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value(2.0));
    }

    @Test
    void testMultiply() throws Exception {
        when(arithmeticUtility.multiply(4.0, 3.0)).thenReturn(12.0);

        mockMvc.perform(post("/api/arithmetic/multiply")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"operand1\": 4.0, \"operand2\": 3.0}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value(12.0));
    }

    @Test
    void testDivide() throws Exception {
        when(arithmeticUtility.divide(6.0, 3.0)).thenReturn(2.0);

        mockMvc.perform(post("/api/arithmetic/divide")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"operand1\": 6.0, \"operand2\": 3.0}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value(2.0));
    }

    @Test
    void testExponent() throws Exception {
        when(arithmeticUtility.exponent(2.0, 3)).thenReturn(8.0);

        mockMvc.perform(post("/api/arithmetic/exponent")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"operand1\": 2.0, \"operand2\": 0.0, \"exponent\": 3}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value(8.0));
    }

    @Test
    void testExponentMissingExponent() throws Exception {
        mockMvc.perform(post("/api/arithmetic/exponent")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"operand1\": 2.0, \"operand2\": 0.0}"))
            .andExpect(status().isBadRequest());
    }
}
