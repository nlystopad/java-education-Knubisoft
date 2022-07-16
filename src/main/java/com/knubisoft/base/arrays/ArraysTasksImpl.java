package com.knubisoft.base.arrays;

import java.util.Arrays;

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
        // find all unique values
        int[] unique = Arrays.stream(array).distinct().toArray();
        // sum all unique
        int finalVal = 0;
        for (int x : unique) {
            finalVal += x;
        }
        return finalVal;
    }

    @Override
    public int[] moveZeroes(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                //find next not 0 value
                for (int y = i; y < array.length; y++) {
                    if (array[y] != 0) {
                        array[i] = array[y];
                        array[y] = 0;
                        break;
                    }
                }
            }
        }
        return array;
    }

    @Override
    public int findFinalValue(int[] nums, int original) {
        for (int i = 0; i < nums.length; i++)
            for (int x : nums) {
                if (x == original) {
                    original *= 2;
                }
            }
        return original;
    }

    @Override
    public String longestCommonPrefix(String[] words) {
        // find the shortest string in array
        if (words.length < 1) {
            return "";
        }
        int min = words[0].length();
        for (String x : words) {
            if (x.length()  < min) {
                min = x.length();
            }
        }
        // find longest common prefix
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < min; i++) {
            char current = words[0].charAt(i);
            for (int j = 1; j < words.length; j++) {
                if (words[j].charAt(i) != current) {
                    return result.toString();
                }
            }
            result.append(current);
        }
        return result.toString();
    }

    @Override
    public int missingNumber(int[] array) {
        int[] distinct = Arrays.stream(array).distinct().toArray();
        Arrays.sort(distinct);
        int i;
        for (i = 0; i < distinct.length; i++) {
            if (distinct[i] != i) {
                return i;
            }
        }
        return i;
    }

    @Override
    public boolean containsDuplicate(int[] array) {
        return false;
    }
}
