package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;

import java.util.List;

public interface BalanceService {
    public BalanceDto createBalance(BalanceDto balanceDto);
    public BalanceDto updateBalance(String balanceId,BalanceDto balanceDto);
}
