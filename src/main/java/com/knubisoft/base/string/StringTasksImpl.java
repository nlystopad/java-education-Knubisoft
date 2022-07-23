package com.knubisoft.base.string;

import java.util.*;

public class StringTasksImpl implements StringTasks {

    @Override
    public String reverseString(String original) {
        if (original == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder newString = new StringBuilder();
        for (int i = original.length() - 1; i >= 0; i--) {
            newString.append(original.charAt(i));
        }
        return newString.toString();
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        if (original == null || toInsert == null || original.length() == 0 || toInsert.length() == 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder returnString = new StringBuilder();
        int middle = original.length() / 2;
        for (int i = 0; i < middle; i++) {
            returnString.append(original.charAt(i));
        }
        returnString.append(toInsert);
        for (int i = middle; i < original.length(); i++) {
            returnString.append(original.charAt(i));
        }
        return returnString.toString();
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        if (original == null || original.length() == 0 || position < 0 || position > original.length()) {
            throw new IllegalArgumentException();
        }
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < position; i++) {
            returnString.append(original.charAt(i));
        }
        returnString.append(toInsert);
        for (int i = position; i < original.length(); i++) {
            returnString.append(original.charAt(i));
        }
        return returnString.toString();
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        if (original == null || toAppend == null || original.length() == 0 || toAppend.length() == 0) {
            throw new NoSuchElementException();
        }
        return original + toAppend;
    }

    @Override
    public boolean isPalindrome(String palindrome) {
        if (palindrome == null) {
            throw new RuntimeException();
        }
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != palindrome.charAt(palindrome.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasLowerCase(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String uniqueCharacters(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < str.length(); j++) {
                // checking if two characters are equal
                if (str.toLowerCase(Locale.ROOT).charAt(i) == str.toLowerCase(Locale.ROOT).charAt(j) && i != j) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                returnString.append(str.charAt(i));
            }
        }
        return returnString.toString();
    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != charToRemove) {
                returnString.append(str.charAt(i));
            }
        }
        return returnString.toString();
    }

    @Override
    public String toCamelCase(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
        String[] words = str.split("[\\W_]+");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == 0) {
                word = word.isEmpty() ? word : word.toLowerCase();
            } else {
                word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            }
            builder.append(word);
        }
        return builder.toString();
    }

    @Override
    public String getCountRepeatableString(String str) { // don't rly understand task
        return null;
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        List<Character> characters = new ArrayList<>();
        for (char c : str.toCharArray()) {
            characters.add(c);
        }
        Collections.sort(characters);
        StringBuilder returnString = new StringBuilder();
        for (char c : characters) {
            returnString.append(c);
        }
        return returnString.toString();
    }
}
