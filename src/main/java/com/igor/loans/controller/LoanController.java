package com.igor.loans.controller;

import com.igor.loans.controller.dto.CustomerLoanRequest;
import com.igor.loans.controller.dto.CustomerLoanResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @PostMapping(value = "/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody CustomerLoanRequest request) {


        return ResponseEntity.ok().build();
    }

}
