package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.exceptionhandler.BalanceNotFoundException;
import com.maveric.balanceservice.exceptionhandler.BalanceNotFoundException;
import com.maveric.balanceservice.mapper.BalanceMapper;
import com.maveric.balanceservice.model.Balance;
import com.maveric.balanceservice.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.maveric.balanceservice.constants.Constants.getCurrentDateTime;

@Service
public class BalanceServiceImpl implements BalanceService{
    @Autowired
    private BalanceRepository repository;

    @Autowired
    private BalanceMapper mapper;
    @Override
    public BalanceDto createBalance(BalanceDto balanceDto) {
        balanceDto.setCreatedAt(getCurrentDateTime());
        balanceDto.setUpdatedAt(getCurrentDateTime());
        Balance balance = mapper.map(balanceDto);
        Balance balanceResult = repository.save(balance);
        return  mapper.map(balanceResult);
    }
}
