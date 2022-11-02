package com.knubisoft.base.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTasksImpl implements PatternTasks {

    @Override
    public boolean haveSetOfCharacters(String text) {
        if (text == null || text.length() == 0 || text.equals(" ")) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("^\\w+$");
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    @Override
    public String matchByCharacters(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("^pq*$");
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? "Found a match!" : "Not matched!";
    }

    @Override
    public String matchStartAndEnd(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("\\Bg\\B");
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? "Found a match!" : "Not matched!";

    }

    @Override
    public String matchIpAddress(String text) {
        if (text == null || text.length() < 2) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("\\b0");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = text.replaceAll("\\b0", "");
        }
        return text;
    }

    @Override
    public String matchVowels(String text) {
        if (text == null || text.length() < 2) {
            throw new IllegalArgumentException();
        }
        return text.replaceAll("[aeiouAEIOU]", "");
    }

    @Override
    public boolean validatePIN(String text) {
        if (text == null || text.length() < 2) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("(\\w{4}|\\w{6}|\\w{8})");
        return pattern.matcher(text).matches();
    }

    @Override
    public String divideDigit(int digit) {
        String s = String.valueOf(digit);
        if (s.length() < 4) {
            return s;
        }
        return divideDigit(Integer.parseInt(s.substring(0, s.length() - 3))) + "#" + s.substring(s.length() - 3);
    }

    @Override
    public String removeAllNonAlphanumericCharacters(String text) {
        if (text == null) {
            throw new RuntimeException();
        }
        return text.replaceAll("[^a-zA-Z]", "");
    }

    @Override
    public boolean validatePhoneNumber(String text) {
        if (text == null || text.length() == 0 || text.equals(" ")) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\d{7}|\\d{10}|\\d{3}\\-\\d{3}\\-\\d{4}|\\(\\d{3}\\)\\d{3}\\-\\d{4}");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    @Override
    public String getLastVowelsByConstraint(String text, int n) {
        if (n < 1 || text == null || text.length() < n) {
            throw new RuntimeException();
        }
        String s = text.replaceAll("(?i)[^aeiou]", "");
        return s.substring(s.length() - n);
    }

    @Override
    public boolean isMathematicalExpression(String text) {
        if (text == null || text.equals("") || text.equals(" ")) {
            throw new IllegalArgumentException();
        }
        return text.matches("((?:(?:^|[-+_*/])(?:\\s*-?\\d+(\\.\\d+)?(?:[eE][+-]?\\d+)?\\s*))+$)");

    }

    @Override
    public String insertDash(String text) {
        if (text == null) throw new RuntimeException();
        return text.replaceAll("(?<=[A-Z])(?=[a-z])", "-");
    }
}
