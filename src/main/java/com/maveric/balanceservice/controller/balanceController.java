package com.maveric.balanceservice.controller;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class balanceController {
    @Autowired
    BalanceService balanceService;

    @PostMapping("accounts/{accountId}/balances")
    public ResponseEntity<BalanceDto> createBalance(@PathVariable String accountId, @RequestBody BalanceDto balanceDto) {
        BalanceDto BalanceDtoResponse = balanceService.createBalance(balanceDto);
        return new ResponseEntity<BalanceDto>(BalanceDtoResponse, HttpStatus.OK);
    }
}
