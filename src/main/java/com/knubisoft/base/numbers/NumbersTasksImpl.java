package com.knubisoft.base.numbers;

import java.math.BigInteger;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {
        firstNumber += secondNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber -= secondNumber;
    }

    @Override
    public boolean isUglyInt(int number) {
        if (number <= 0) {
            return false;
        }
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    @Override
    public int addDigits(int number) {
        int sum;
        do {
           sum = add(number);
           number = sum;
        } while (sum > 9);
        return sum;
    }

    /**
     * technical method
     * add all digits of number
     * @param number to check.
     * @return sum of digits of number
     */
    public int add(int number) {
        int digit, sum = 0;
        while (number > 0) {
            digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }

    @Override
    public boolean isHarshadNumber(int number) {
        if (number == 0) {
            return false;
        }
        return number % add(number) == 0;
    }

    @Override
    public boolean isPrime(int number) {
        return false;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        return false;
    }

    @Override
    public BigInteger factorial(int number) {
        return BigInteger.ZERO;
    }

    @Override
    public boolean palindrome(int number) {
        return false;
    }

    @Override
    public boolean isAutomorphic(int number) {
        return false;
    }
}
