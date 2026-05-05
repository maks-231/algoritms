package org.example.searching;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class Binary {
    public static int binarySearchRecursion(int[] values, int valueToFind, int l, int r) {
        Instant start = Instant.now();

        if (l == r) {
            return (values[l] == valueToFind) ? l : -1;
        }

        int m = l + (r - l) / 2;

        if (valueToFind > values[m]) {
            return binarySearchRecursion(values, valueToFind, m + 1, r);
        } else if (values[m] > valueToFind) {
            return binarySearchRecursion(values, valueToFind, l, m - 1);
        }

        Instant end = Instant.now();

        System.out.println("Executing time " + Duration.between(start, end).getNano() / 1000_000_000L);
        return m;
    }

    private static int binarySearch(int[] sortedArray, int valueToFind, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArray[mid] < valueToFind) {
                low = mid + 1;
            } else if (sortedArray[mid] > valueToFind) {
                high = mid - 1;
            } else if (sortedArray[mid] == valueToFind) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
