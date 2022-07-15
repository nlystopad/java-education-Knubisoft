package com.knubisoft.base.arrays;

public class ArraysTasksImpl implements ArraysTasks {

    @Override
    public int[] reverse(int[] array) {
        if (array.length == 0) {
            return array;
        } else {
            int[] returnArr = new int[array.length];
            for (int i = 1; i <= array.length; i++) {
                returnArr[i - 1] = array[array.length - i];
            }
            return returnArr;
        }
    }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] returnArr = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, returnArr, 0, array1.length);
        System.arraycopy(array2, 0, returnArr, array1.length, array2.length);
        return returnArr;
    }

    @Override
    public int[] findMax3InArray(int[] array) {
        if (array.length < 3) {
            return array;
        } else {
            int[] returnArr = new int[3];
            for (int x : array) {
                if (x > returnArr[0]) {
                    returnArr[2] = returnArr[1];
                    returnArr[1] = returnArr[0];
                    returnArr[0] = x;
                } else if (x > returnArr[1]) {
                    returnArr[2] = returnArr[1];
                    returnArr[1] = x;
                } else if (x > returnArr[2]) {
                    returnArr[2] = x;
                }
            }
            return returnArr;
        }
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int returnVal = 1;
        int currentSeq = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]) {
                currentSeq++;
                returnVal = currentSeq;
            } else {
                currentSeq = 1;
            }
        }
        return returnVal;
    }

    @Override
    public int sumOfAllUniqueElements(int[] array) {
        return -1;
    }

    @Override
    public int[] moveZeroes(int[] array) {
        return null;
    }

    @Override
    public int findFinalValue(int[] nums, int original) {

        return -1;
    }

    @Override
    public String longestCommonPrefix(String[] words) {
        return null;
    }

    @Override
    public int missingNumber(int[] array) {
        return -1;
    }

    @Override
    public boolean containsDuplicate(int[] array) {
        return false;
    }
}
