package org.example.sorting;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class BubbleSorting {

    public int[] getSortedArrayV1(int[] array) {
        long startTime = System.nanoTime();
        int count =1;
        for (int i = array.length - 1; i > 1 ; i--) {
            for(int j = 0; j < i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
                count++;
            }
        }
        long endTime = System.nanoTime();

        System.out.println("Executing time " + (double)(endTime - startTime) / 1_000_000 + " мс");
        System.out.println("getSortedArrayV1, Number of loops = "+ count);
        return array;
    }

    public int[] getSortedArrayV2(int[] intArray) {
        int count =1;
        for (int i = 0; i < intArray.length; i++) {
            for(int j = i + 1; j < intArray.length; j++) {
                if(intArray[i] > intArray[j] ) {
                    int min = intArray[j];
                    intArray[j] = intArray[i];
                    intArray[i] = min;
                }
                count++;
            }
        }
        System.out.println("getSortedArrayV2, Number of loops = "+ count);
        return intArray;
    }
}
