package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;
import com.maveric.balanceservice.repository.BalanceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BalanceServiceImpTest {
    @Mock
    private BalanceRepository balanceRepository;
    @InjectMocks
    private BalanceServiceImpl balanceService;

    @Test
    void shouldReturnBalanceWhenCreateBalanceInvoked() {

        when(balanceRepository.save(any())).thenReturn(getBalances());

        BalanceDto balance = balanceService.createBalance(getBalanceDto());

        assertNotNull(balance);
        assertSame(balance.getAccountId(),getBalances().getAccountId());
    }
    @Test
    void ShouldReturnBalanceDetailswhenBalanceByIdInvoked() {
        when(balanceRepository.findById(any(String.class))).thenReturn(Optional.of(getBalances()));

        BalanceDto balanceDto = balanceService.getBalanceDetails("123");

        assertNotNull(balanceDto);
        assertSame(balanceDto.getAccountId(), getBalances().getAccountId());
    }
    @Test
    void shouldDeleteBalancewhenDeleteBalanceInvoked(){

        balanceRepository.deleteById("123");
        verify(balanceRepository,atLeastOnce()).deleteById("123");
    }
    @Test
    void shouldReturnBalanceswhenBalancenotemptyindb(){
        List<Balance> balances = new ArrayList<Balance>();
        balances.add(getBalances());
        when(balanceRepository.findAll()).thenReturn(balances);
        assertFalse(balanceService.getBalances(1,8).isEmpty());

    }

    private Balance getBalances() {
        Balance balance = new Balance();
        balance.set_id("1");
        balance.setAccountId("12");
        balance.setCurrency("INR");
        balance.setAmount(500);
        balance.setCreatedAt(LocalDateTime.parse("1986-04-08 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        balance.setUpdatedAt(LocalDateTime.now());
        return balance;
    }

    private  BalanceDto getBalanceDto() {

        BalanceDto balanceDto = new BalanceDto();
        balanceDto.set_id("1");
        balanceDto.setAccountId("12");
        balanceDto.setCurrency("INR");
        balanceDto.setAmount(500);
        balanceDto.setCreatedAt(LocalDateTime.parse("1986-04-08 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        balanceDto.setUpdatedAt(LocalDateTime.now());
        return balanceDto;
    }
}
