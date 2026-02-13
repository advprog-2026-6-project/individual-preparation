package com.example.individualprep.controller;

import com.example.individualprep.service.VectorUtility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VectorController.class)
class VectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VectorUtility vectorUtility;

    @Test
    void testAdd() throws Exception {
        when(vectorUtility.add(any(double[].class), any(double[].class)))
            .thenReturn(new double[]{5.0, 7.0, 9.0});

        mockMvc.perform(post("/api/vector/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"vector1\": [1,2,3], \"vector2\": [4,5,6]}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result[0]").value(5.0))
            .andExpect(jsonPath("$.result[1]").value(7.0))
            .andExpect(jsonPath("$.result[2]").value(9.0));
    }

    @Test
    void testSubtract() throws Exception {
        when(vectorUtility.subtract(any(double[].class), any(double[].class)))
            .thenReturn(new double[]{3.0, 3.0, 3.0});

        mockMvc.perform(post("/api/vector/subtract")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"vector1\": [4,5,6], \"vector2\": [1,2,3]}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result[0]").value(3.0))
            .andExpect(jsonPath("$.result[1]").value(3.0))
            .andExpect(jsonPath("$.result[2]").value(3.0));
    }

    @Test
    void testMultiply() throws Exception {
        when(vectorUtility.multiply(any(double[].class), eq(3)))
            .thenReturn(new double[]{3.0, 6.0, 9.0});

        mockMvc.perform(post("/api/vector/multiply")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"vector1\": [1,2,3], \"scalar\": 3}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result[0]").value(3.0))
            .andExpect(jsonPath("$.result[1]").value(6.0))
            .andExpect(jsonPath("$.result[2]").value(9.0));
    }

    @Test
    void testMultiplyMissingScalar() throws Exception {
        mockMvc.perform(post("/api/vector/multiply")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"vector1\": [1,2,3]}"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void testDotProduct() throws Exception {
        when(vectorUtility.dotProduct(any(double[].class), any(double[].class)))
            .thenReturn(32.0);

        mockMvc.perform(post("/api/vector/dotProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"vector1\": [1,2,3], \"vector2\": [4,5,6]}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.scalarResult").value(32.0));
    }

    @Test
    void testNorm() throws Exception {
        when(vectorUtility.norm(any(double[].class)))
            .thenReturn(new double[]{0.6, 0.8});

        mockMvc.perform(post("/api/vector/norm")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"vector1\": [3,4]}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result[0]").value(0.6))
            .andExpect(jsonPath("$.result[1]").value(0.8));
    }
}
