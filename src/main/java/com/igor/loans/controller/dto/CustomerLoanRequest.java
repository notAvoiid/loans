package com.igor.loans.controller.dto;

public record CustomerLoanRequest(
   Integer age,
   String CPF,
   String name,
   Double income,
   String location
) {}
