package Test1;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.Arrays;

public class test1 {
    public static void quickSort(long[] arr) {
        quickSortInternal(arr,0,arr.length - 1);
    }
    //区间：[lowIndex,highIndex]
    private static void quickSortInternal(long[] arr,int lowIndex,int highIndex) {
        int size = highIndex - lowIndex + 1;
        if(size <= 1) {
            return;
        }
        //选择其中一个数（最左边）--arr[lowIndex]
        //执行partition，小的放左边，大的放右边
        //keyIndex是经过partition之后，选出来的数最终所在下标
        int keyIndex = partiton(arr,lowIndex,highIndex);
        quickSortInternal(arr,lowIndex,highIndex - 1);
        quickSortInternal(arr,highIndex + 1,highIndex);
    }
    private static int partiton(long[] arr,int lowIndex,int highIndex) {
        return partitionWK(arr,lowIndex,highIndex);

    }
    private static void swap(long[] arr,int index1,int index2) {
        long t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }

    private static int partitionWK(long[] arr,int lowIndex,int highIndex) {
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        long key = arr[lowIndex];

        while (leftIndex < rightIndex){
            while(leftIndex < rightIndex && key >= arr[rightIndex]) {
                //arr[leftIndex] = arr[rightIndex];
                rightIndex--;
            }
            arr[leftIndex] = arr[rightIndex];
            while(leftIndex < rightIndex && key <= arr[leftIndex]) {
                leftIndex++;
            }

            arr[rightIndex] = arr[leftIndex];
        }
        arr[leftIndex] = key;
        return leftIndex;
    }
    public  static void swap1(long[] arr,int left,int right) {
        long t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;
    }

    private static void 分割(long[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            while(left < right && arr[left] % 2 != 0) {
                left++;
            }
            while(left < right && arr[right] % 2 == 0) {
                right--;
            }
            swap1(arr,left,right);
        }
    }

    public static void main(String[] args) {
        long[] arr = {};
        分割(arr);
        System.out.println(Arrays.toString(arr));
    }


}
