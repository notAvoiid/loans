package com.igor.loans.domain;

import com.igor.loans.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan {

        @Test
        void ShouldBeTrueWhenIncomeIsEqual() {
            var costumer = CustomerFactory.build(5000.0);
            assertTrue(costumer.isIncomeEqualOrLowerThan(5000.0));
        }

        @Test
        void ShouldBeTrueWhenIncomeIsLowerThan() {
            var costumer = CustomerFactory.build(5000.0);
            assertTrue(costumer.isIncomeEqualOrLowerThan(9000.0));
        }

        @Test
        void ShouldBeFalseWhenIncomeGreaterThanValue() {
            var costumer = CustomerFactory.build(5000.0);
            assertFalse(costumer.isIncomeEqualOrLowerThan(3000.0));
        }
    }


}