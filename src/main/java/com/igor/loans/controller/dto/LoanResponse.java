package com.igor.loans.controller.dto;

import com.igor.loans.domain.enums.LoanType;

public record LoanResponse(
        LoanType type,
        Double interestRate
) {
}
