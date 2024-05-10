package com.igor.loans.controller;

import com.igor.loans.controller.dto.CustomerLoanRequest;
import com.igor.loans.controller.dto.CustomerLoanResponse;
import com.igor.loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(value = "/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest request) {

        var loanResponse = loanService.checkLoanAvailability(request);

        return ResponseEntity.ok().body(loanResponse);
    }

}
