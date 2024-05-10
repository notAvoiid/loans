package com.igor.loans.domain;

import com.igor.loans.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Nested
    class isIncomeEqualOrGreaterThan {

        @Test
        void ShouldBeTrueWhenIncomeIsEqual() {
            var costumer = CustomerFactory.build(5000.0);
            assertTrue(costumer.isIncomeEqualOrGreaterThan(5000.0));
        }

        @Test
        void ShouldBeTrueWhenIncomeIsGreaterThan() {
            var costumer = CustomerFactory.build(5000.0);
            assertTrue(costumer.isIncomeEqualOrGreaterThan(3000.0));
        }

        @Test
        void ShouldBeFalseWhenIncomeLowerThanValue() {
            var costumer = CustomerFactory.build(5000.0);
            assertFalse(costumer.isIncomeEqualOrGreaterThan(8000.0));
        }
    }


    @Nested
    class isIncomeBetween {

        @Test
        void ShouldBeTrueWhenIncomeIsBetween() {
            var costumer = CustomerFactory.build(5000.0);
            assertTrue(costumer.isIncomeBetween(3000.0, 8000));
        }

        @Test
        void ShouldBeTrueWhenIncomeIsEqualToMin() {
            var costumer = CustomerFactory.build(5000.0);
            assertTrue(costumer.isIncomeBetween(5000.0, 8000));
        }


        @Test
        void ShouldBeTrueWhenIncomeIsEqualToMax() {
            var costumer = CustomerFactory.build(8000.0);
            assertTrue(costumer.isIncomeBetween(5000.0, 8000));
        }

        @Test
        void ShouldBeFalseWhenIncomeIsNotBetween() {
            var costumer = CustomerFactory.build(5000.0);
            assertFalse(costumer.isIncomeBetween(6000.0, 10000));
        }

    }

    @Nested
    class isAgeLowerThan {

        @Test
        void ShouldBeTrueWhenAgeIsLowerThan() {
            var costumer = CustomerFactory.build(25);
            assertTrue(costumer.isAgeLowerThan(30));
        }

        @Test
        void ShouldBeFalseWhenAgeIsNotLowerThan() {
            var costumer = CustomerFactory.build(25);
            assertFalse(costumer.isAgeLowerThan(22));
        }

        @Test
        void ShouldBeFalseWhenAgeIsEqual() {
            var costumer = CustomerFactory.build(25);
            assertFalse(costumer.isAgeLowerThan(25));
        }

    }
}