package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IncorrectArgumentException {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the collection: ");

        int capacity = input.nextInt();
        DataCollection dataCol = new DataCollection(capacity);

        System.out.println("Enter the unique integer numbers:");


        for (int i = 0; i < capacity; ) {
            var value = input.next();

            if (!dataCol.checkCorrectValue(value)) {
                continue;
            }

            int intValue = Integer.parseInt(value);

            if (dataCol.checkDuplicateValue(intValue)) {
                System.out.println("Please, don't use duplicates.");
                continue;
            }

            dataCol.addInteger(intValue);
            i++;
        }

        System.out.print("Maximum value in collection: ");
        System.out.println(dataCol.maxValue());

        System.out.print("The sum of even numbers: ");
        System.out.println(dataCol.sumOddValue());

        System.out.print("Revers of the collection: ");
        System.out.println(dataCol.reversSorted());
    }
}