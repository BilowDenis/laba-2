package org.example;

import org.example.Sorter.*;
import static org.example.SortingType.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random random = new Random();
    static int[] counts = new int[] {10, 1000, 10000, 1000000};

    public static void main(String[] args) {
        for (int count: counts) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            System.out.println("\n\nCount: " + count);
            for (int i = 0; i < count; i++) {
                arrayList.add(random.nextInt(count));
            }
            System.out.println(arrayList.subList(0, Math.min(arrayList.size(), 50)));

            for (SortingType type: new SortingType[]{Bubble, Merge, Quick, Shell}) {
                ISorter sorter = choiceMethod(type);
                ArrayList<Integer> input = new ArrayList<>(arrayList);

                long startTime = System.currentTimeMillis();
                ArrayList<Integer> sortedList = sorter.sort(input);
                long endTime = System.currentTimeMillis();
                System.out.printf("%s: %d ms - ", type, endTime - startTime);
                System.out.println(sortedList.subList(0, Math.min(sortedList.size(), 50)));
            }
        }
    }

    private static ISorter choiceMethod(SortingType type) {
        ISorter sorter = null;

        switch (type) {
            case Bubble -> sorter = new BubbleSorter();
            case Merge -> sorter = new MergeSorter();
            case Quick -> sorter = new QuickSorter();
            case Shell -> sorter = new ShellSorter();
        }
        return sorter;
    }
}