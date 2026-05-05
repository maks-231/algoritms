package org.example;

import org.example.sorting.BubbleSorting;
import org.example.sorting.SortBySelect;

public class SortingArray {

    public static void printArray(int[] array){
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array1 =  new int[] {3, 4, 1, 8, 2, 6};
        int[] array2 =  new int[] {3, 4, 1, 8, 2, 6};

       BubbleSorting bs = new BubbleSorting();
        SortBySelect sbs = new SortBySelect();

        array1 = bs.getSortedArrayV1(array1);
//        array2 = bs.getSortedArrayV2(array2);
        array2 = sbs.getSortedArray2(array2);

        SortingArray.printArray(array1);
        SortingArray.printArray(array2);

//        Binary.binarySearchRecursion(array1, 6, 0, array1.length);
    }
}