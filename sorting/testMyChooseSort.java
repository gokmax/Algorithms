import java.util.Arrays;

public class testMyChooseSort {

    public static void chooseSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j ++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }

    public static void main (String [] args) {

        int nums[] = {3, 2, 1, 4, 5, 6};
        chooseSort(nums, 6);
        for (int i = 0; i < 6; ++ i) StdOut.println(nums[i]);
    }
}
