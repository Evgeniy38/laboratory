package org.example;

import java.util.*;

public class DataCollection {

    private static final String MESSAGE_INCORRECT_SIZE = "Incorrect collection size";
    List<Integer> integersCollection;

    public DataCollection(int capacity) throws IncorrectArgumentException {

        if (capacity <= 0) {
            throw new IncorrectArgumentException(MESSAGE_INCORRECT_SIZE);
        }

        integersCollection = new ArrayList<>(capacity);
    }

    public boolean checkCorrectValue(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect value, enter the integer number.");
            return false;
        }
    }

    public boolean checkDuplicateValue(int input) {
        return integersCollection.contains(input);
    }

    public void addInteger(Integer input) {
        integersCollection.add(input);
    }

    public int maxValue() {
        return integersCollection.stream()
                .mapToInt(Integer::intValue)
                .max().orElseThrow(NoSuchElementException::new);
    }

    public int sumOddValue() {
        return integersCollection.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> reversSorted() {
        return integersCollection.stream()
                .sorted((Comparator.comparingInt(integersCollection::indexOf)).reversed())
                .toList();
    }
}
