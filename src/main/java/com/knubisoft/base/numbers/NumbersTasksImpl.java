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
     *
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
        for (int i = 2; i < number; i++) { // actually you don't rly need to check all the numbers, but to be sure i want to lose some speed and check all the numbers between 2 and number
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        int sum = 0, temp = number, pow = 0;
        while (temp > 0) {
            pow++;
            temp /= 10;
        }
        temp = number;
        while (temp > 0) {
            sum += Math.pow(temp % 10, pow);
            temp /= 10;
        }
        return number == sum;
    }

    @Override
    public BigInteger factorial(int number) {
        BigInteger returnValue = new BigInteger("1");
        while (number > 1){
            returnValue = returnValue.multiply(BigInteger.valueOf(number));
            number--;
        }
        return returnValue;
    }

    @Override
    public boolean palindrome(int number) {
        String str = String.valueOf(number);
        for ( int  i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isAutomorphic(int number) {
        String strNumber = String.valueOf(number);
        String strSquare = String.valueOf((long) Math.pow(number, 2));
        return strNumber.charAt(strNumber.length()-1) == strSquare.charAt(strSquare.length()-1);
    }
}
