package com.igor.loans.controller.dto;

import com.igor.loans.domain.LoanType;

public record LoanResponse(
        LoanType type,
        Double interestRate
) {
}
