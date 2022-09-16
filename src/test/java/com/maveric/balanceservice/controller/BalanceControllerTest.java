package com.maveric.balanceservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.repository.BalanceRepository;
import com.maveric.balanceservice.service.BalanceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(balanceController.class)
@ExtendWith(MockitoExtension.class)
public class BalanceControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper map;
    @MockBean
    private BalanceService mockService;
    @MockBean
    private BalanceRepository mockRepo;

    @Test
    void shouldGetBalanceWhenRequestMadeToGetBalance() throws Exception {
        mvc.perform(get("/api/v1/accounts/" + "1" +"/balances").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void ShouldCreateBalanceWhenPostBalanceIsInvoked() throws Exception {
        BalanceDto balanceDto = new BalanceDto();
        balanceDto.set_id("1");
        balanceDto.setAccountId("12");
        balanceDto.setCurrency("INR");
        balanceDto.setAmount(500);
        balanceDto.setCreatedAt(LocalDateTime.parse("1986-04-08 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        balanceDto.setUpdatedAt(LocalDateTime.now());

        mvc.perform(post("/api/v1/accounts/" + "1" + "/balances")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(map.writeValueAsBytes(balanceDto)))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void shouldGetBalanceDetailsWhenGetBalanceByIdInvoked() throws Exception {
        BalanceDto balanceDto = new BalanceDto();
        balanceDto.set_id("1");
        balanceDto.setAccountId("12");
        balanceDto.setCurrency("INR");
        balanceDto.setAmount(500);
        balanceDto.setCreatedAt(LocalDateTime.parse("1986-04-08 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        balanceDto.setUpdatedAt(LocalDateTime.now());

        mvc.perform(get("/api/v1/accounts/" + "1" + "/balances/" + "12").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void ShouldDeleteBalanceWhenDeleteBalanceByIdRequestIsMade() throws Exception {

        mvc.perform(delete("/api/v1/accounts/" + "13" + "/balances/" + "12").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void ShouldUpdateBalanceWhenPutBalanceIsInvoked() throws Exception {
        BalanceDto balanceDto = new BalanceDto();
        balanceDto.set_id("1");
        balanceDto.setAccountId("12");
        balanceDto.setCurrency("INR");
        balanceDto.setAmount(700);
        balanceDto.setCreatedAt(LocalDateTime.parse("1986-04-08 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        balanceDto.setUpdatedAt(LocalDateTime.now());

        mvc.perform(post("/api/v1/accounts/" + "12" + "/balances/" + "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(map.writeValueAsBytes(balanceDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
