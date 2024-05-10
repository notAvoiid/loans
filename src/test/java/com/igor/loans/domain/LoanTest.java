package com.igor.loans.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable {

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLess3K() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5KAndAgeIsLessThan30AndLocationIsSP() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
            doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isPersonalLoanAvailable());
        }

    }

    @Nested
    class isGuaranteedLoanAvailable {

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLess3K() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
            assertTrue(loan.isGuaranteedAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5KAndAgeIsLessThan30AndLocationIsSP() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
            doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isGuaranteedAvailable());
        }

    }

    @Nested
    class isConsignmentAvailable {

        @Test
        void shouldBeAvailableWhenIncomeEqualOrGreaterThan5k() {
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.0);
            assertTrue(loan.isConsignmentAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsNotEqualOrGreaterThan5k() {
            doReturn(false).when(customer).isIncomeEqualOrGreaterThan(5000.0);
            assertFalse(loan.isConsignmentAvailable());
        }

    }

    @Nested
    class getPersonalLoanInterestRate {

        @Test
        void shouldInterestRateBeFour() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
            assertEquals(4.0, loan.getPersonalLoanInterestRate());
        }


        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
            assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInterestRate());
        }
    }

    @Nested
    class getGuaranteedLoanInterestRate {

        @Test
        void shouldInterestRateBeThree() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
            assertEquals(3.0, loan.getGuaranteedLoanInterestRate());
        }


        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
            assertThrows(LoanNotAvailableException.class, () -> loan.getGuaranteedLoanInterestRate());
        }
    }

    @Nested
    class getConsignmentLoanInterestRate {

        @Test
        void shouldInterestRateBeTwo() {
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.0);
            assertEquals(2.0, loan.getConsignmentLoanInterestRate());
        }


        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrGreaterThan(5000.0);
            assertThrows(LoanNotAvailableException.class, () -> loan.getConsignmentLoanInterestRate());
        }
    }
}