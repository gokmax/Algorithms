/*
 * java 中main调用函数必须是static方法
 */

import java.util.Arrays;

public class testMyInsertionSort {

    public static void insertionSort(int[] nums, int n) {

        int l = nums.length;

        for (int i = 1; i < l; i ++) {
            int key = nums[i];
            int j = i;
            while (j >= 1 && key < nums[j - 1] ) { // 注意条件的短路！！！最优条件必须放在最前！！！
                nums[j] = nums[j - 1];
                j --;
            }
            nums[j] = key;
        }
    }

    public static void main (String [] args) {
        int nums[] = {3, 2, 1, 4, 5, 6};
        insertionSort(nums, 6);
        for (int i = 0; i < 6; ++ i) StdOut.println(nums[i]);
    }

}
