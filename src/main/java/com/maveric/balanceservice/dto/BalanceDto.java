package com.maveric.balanceservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class BalanceDto {
    private String  _id;
    private String accountId;
    private Number amount;
    private String currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
