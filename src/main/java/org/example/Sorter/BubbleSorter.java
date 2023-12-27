package org.example.Sorter;
import java.util.ArrayList;
import java.util.Collections;

public class BubbleSorter implements ISorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        int n = input.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (input.get(j) > input.get(j + 1)) {
                    Collections.swap(input, j, j + 1);
                }
            }
        }

        return input;
    }
}
