package hw.hw19QuickSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] arr1 = {12, 4, 5, 6, 7, 3, 1, 15};
        int[] expectedArr1 = {1, 3, 4, 5, 6, 7, 12, 15};
        QuickSort.quickSort(arr1, 0, arr1.length - 1);
        assertArrayEquals(expectedArr1, arr1);

        int[] arr2 = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] expectedArr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        QuickSort.quickSort(arr2, 0, arr2.length - 1);
        assertArrayEquals(expectedArr2, arr2);
    }
}