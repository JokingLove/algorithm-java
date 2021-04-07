package com.jokinglove.algorithm.array;

/**
 * 从数组中找到两个数之和为给定值得下标
 * @author guoyongqiang
 */
public class FindTwoNumSumIndexFromArray {


    public static void main(String[] args) {
        int[] arrays = {1, 2, 5, 7, 11, 12, 15};
        int target = 9;
        int[] result = findIndex(arrays, target);
        System.out.println("结果是：");
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] findIndex(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while(i < j) {
            if(arr[i] + arr[j] > target) {
                j--;
            }

            if(arr[i] + arr[j] < target) {
                i++;
            }

            if(arr[i] + arr[j] == target) {
                return new int[] {i, j};
            }
        }
        return null;
    }

}
