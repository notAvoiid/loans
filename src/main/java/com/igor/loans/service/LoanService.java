package com.igor.loans.service;

import com.igor.loans.controller.dto.CustomerLoanRequest;
import com.igor.loans.controller.dto.CustomerLoanResponse;
import com.igor.loans.controller.dto.LoanResponse;
import com.igor.loans.domain.Loan;
import com.igor.loans.domain.enums.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest request) {

        var customer = request.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonalLoanAvailable()) loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        if (loan.isConsignmentAvailable()) loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
        if (loan.isGuaranteedAvailable()) loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));

        return new CustomerLoanResponse(request.name(), loans);
    }

}
