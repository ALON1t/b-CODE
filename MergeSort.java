package sort;

import java.util.Random;

public class MergeSort {
    public static void mergeSort(long[] arr) {
        mergeSortInternal(arr, 0, arr.length);
    }
    // 区间范围左闭右开
    // arr[lowIndex, highIndex)
    private static void mergeSortInternal(long[] arr, int lowIndex, int highIndex) {
        int size = highIndex - lowIndex;//数组个数
        if (size <= 1) {
            return;
        }
        int middleIndex = (lowIndex + highIndex) / 2;
        // 左区间：[lowIndex, middleIndex)
        // 右区间：[middleIndex, highIndex)
        mergeSortInternal(arr, lowIndex, middleIndex);//对左边区间进行排序
        mergeSortInternal(arr, middleIndex, highIndex);//对右边区间进行排序

        // 左右两个区间都有序了
        合并两个有序区间(arr, lowIndex, middleIndex, highIndex);//合并有序区间
    }

    private static void 合并两个有序区间(long[] arr, int lowIndex, int middleIndex, int highIndex) {
        int size = highIndex - lowIndex;
        long[] extraArray = new long[size];

        int leftIndex = lowIndex;
        int rightIndex = middleIndex;
        int extraIndex = 0;

        // 两个队伍都有人
        while (leftIndex < middleIndex && rightIndex < highIndex) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                extraArray[extraIndex] = arr[leftIndex];
                extraIndex++;
                leftIndex++;
            } else {
                extraArray[extraIndex] = arr[rightIndex];
                extraIndex++;
                rightIndex++;
            }
        }
        // 有个队伍没有人
        if (leftIndex < middleIndex) {
            while (leftIndex < middleIndex) {
                extraArray[extraIndex++] = arr[leftIndex++];
            }
        } else {
            while (rightIndex < highIndex) {
                extraArray[extraIndex++] = arr[rightIndex++];
            }
        }
        // 最后把数据从新数组统一搬回去
        // 新数组 [0, size)
        // 搬回去的下标范围 [lowIndex, highIndex)
        for (int i = 0; i < size; i++) {
            arr[i + lowIndex] = extraArray[i];
        }

    }
}

