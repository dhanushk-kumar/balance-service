package com.maveric.balanceservice.utility;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;

public class ModelDtoTransformer {

    public static Balance toEntity(BalanceDto balanceResponse) {
        return new Balance(
                balanceResponse.get_id(),
                balanceResponse.getAccountId(),
                balanceResponse.getAmount(),
                balanceResponse.getCurrency(),
                balanceResponse.getCreatedAt(),
                balanceResponse.getUpdatedAt()
        );
    }

    public static BalanceDto toDto(Balance balance) {
        return new BalanceDto(
                balance.get_id(),
                balance.getAccountId(),
                balance.getAmount(),
                balance.getCurrency(),
                balance.getCreatedAt(),
                balance.getUpdatedAt()
        );
    }
}
