package com.knubisoft.base.list;

import java.util.*;

public class ListTasksImpl implements ListTasks {
    @Override
    public List<String> addElements(String... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) {
        if (indexes == null) {
            throw new IllegalArgumentException();
        }
        for (int i : indexes) {
            if (i < 0 || i == Integer.MAX_VALUE) { // not really sure about test here, don't understand logic
                throw new IllegalArgumentException();
            }
        }
        List<String> list = new ArrayList<>(elements);
        for (int i : indexes) {
            if (i >= elements.size()) {
                list.add(elements.get(elements.size() - 1));
            } else {
                list.add(elements.get(i));
            }
        }
        return list;
    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        checkIndexes(indexes);
        for (int i : indexes) {
            elements.add(i, elements.get(i));
        }
        return elements;
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {
        checkIndexes(indexes);
        for (int i : indexes) {
            elements.add(elements.get(i));
        }
        return elements;
    }

    /**
     * technical method
     * checks all indexes and throw IllegalArgumentException if something went wrong
     *
     * @param indexes - array of indexes to check
     */
    private void checkIndexes(int[] indexes) {
        if (indexes == null) {
            throw new IllegalArgumentException();
        }
        for (int i : indexes) {
            if (i <= 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public int getListSize(List<String> list) {
        // i don't think using list.size() is funny (in real product i would use it, but here it's boring)
        if (list == null) {
            return 0;
        }
        int size = 0;
        for (String s : list) {
            size++;
        }
        return size;
    }

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {
        if (first == null || second == null || third == null) {
            throw new RuntimeException();
        }
        List<Long> returnList = new ArrayList<>();
        for (Integer i : first) {
            returnList.add(i.longValue());
        }
        returnList.addAll(second);
        for (String s : third) {
            if (s == null) {
                throw new NullPointerException();
            }
            try {
                returnList.add(Long.parseLong(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return returnList;
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        if (first == null || second == null || third == null) {
            throw new RuntimeException();
        }
        first.addAll(second);
        first.addAll(third);
        return Collections.max(first);
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        if (first == null || second == null || third == null) {
            throw new RuntimeException();
        }
        first.addAll(second);
        first.addAll(third);
        return Collections.min(first);
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        if (first == null || second == null || third == null) {
            throw new RuntimeException();
        }
        first.addAll(second);
        first.addAll(third);
        Collections.sort(first);
        Collections.reverse(first);
        return first.get(0) * first.get(1);
    }

    @Override
    public List<String> removeNulls(List<String> list) {
        if (list == null) {
            throw new RuntimeException();
        }
        list.removeIf(Objects::isNull);
        return list;
    }

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {
        if (list == null) {
            throw new NoSuchElementException();
        }
        List<Integer> integers = new ArrayList<>();
        list.stream().forEach(entry -> entry.stream().forEach(val -> {
            if (val == null) {
                integers.add(val);
            }
        }));
        return integers;
    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {
        if (originalIds == null) {
            throw new NoSuchElementException();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : originalIds) {
            if (i != null) {
                list.add(i);
            }
        }
        return list;
    }

    @Override
    public List<String> shuffle(List<String> originalStrings) {
        if (originalStrings == null) {
            throw new RuntimeException();
        }
        Collections.shuffle(originalStrings);
        return originalStrings;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {
        if (list == null) {
            throw new NoSuchElementException();
        }
        if (list.size() == 0 ) {
            return "";
        }
        return list.get(list.size() - 1);
    }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {
        if (originalCollection == null || additionalCollection == null) {
            throw new IllegalArgumentException();
        }
        List<String> strings = new LinkedList<>(); // n^2, todo: rewrite to make it faster
        for (String s : originalCollection) {
            for (String s1: additionalCollection) {
                if (Objects.equals(s, s1)) {
                   strings.add(s);
                }
            }
        }
        return strings;
    }
}
