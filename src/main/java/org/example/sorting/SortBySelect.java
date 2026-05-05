package org.example.sorting;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class SortBySelect {

    public int[] getSortedArray1(int[] array) {
        for (int i = 0; i < array.length - 1 ; i++) {
            int m = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[m]) {
                    m=j;
                }
            }
            int tmp = array[i];
            array[i] = array[m];
            array[m] = tmp;
        }
        return array;
    }

    public int[] getSortedArray2(int[] intArray){
        long startTime = System.nanoTime();
        int count = 1;
        for(int pos = 1; pos < intArray.length; pos++){
            int currentIndex = pos;

            while(currentIndex > 0 && intArray[currentIndex] < intArray[currentIndex -1]){
                int tmp = intArray[currentIndex];
                intArray[currentIndex] = intArray[currentIndex -1];
                intArray[currentIndex - 1] = tmp;
                currentIndex = currentIndex -1;
                count++;
            }
        }
        long endTime = System.nanoTime();

        System.out.println("Executing time " + (double)(endTime - startTime) / 1_000_000 + " мс");
        System.out.println("getSortedArray2, Number of loops = "+ count);
        return intArray;
    }
}




