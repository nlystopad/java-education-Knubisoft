package com.knubisoft.base.bool;

public class BoolTasksImpl implements BoolTasks {

    @Override
    public Boolean isTrueAutobox(boolean value) {
        return (Boolean) value;
    }

    @Override
    public Boolean isFalseAutobox(boolean value) {
        return (Boolean) value;
    }

    @Override
    public boolean isTrueUnbox(Boolean value) {
        return value;
    }

    @Override
    public Boolean isFalseUnbox(boolean value) {
        return value;
    }

    @Override
    public boolean andFunction(int digit, String string) {
        if (string == null) {
            return false;
        }
        return String.valueOf(digit).length() == string.length() && Integer.parseInt(string) == digit;
    }

    @Override
    public boolean orFunction(int digit, String string) {
        if (string == null || String.valueOf(digit).length() != string.length()) {
            return false;
        }
        boolean returnVal;
        try {
            returnVal = Integer.parseInt(string) == digit;
        } catch (NumberFormatException e) {
            return false;
        }
        return returnVal;
    }

    // kinda weird, don't understand task (for next1 also)
    @Override
    public boolean andComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int range) {
        return false;
    }

    @Override
    public boolean orComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int generatedThirdDigit, int range) {
        return false;
    }

    @Override
    public boolean isSameSizeArray(Object[] firstArray, Object... secondArray) {
        if (firstArray == null || secondArray == null) {
            return false;
        }
        return firstArray.length == secondArray.length;
    }

    @Override
    public boolean isSameCharactersCount(String username, String name, int maxLength) {
        if (maxLength == 0 || username == null || name == null || username.length() == 0 || name.length() == 0) { // todo : too much conditions in 1 if, should be refactored
            return false;
        }
        return username.length() == name.length();
    }
}
