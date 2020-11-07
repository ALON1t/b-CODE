import java.util.Arrays;

public class MyPriorityQueue {
    private Integer[] arr;
    private int size;

    public MyPriorityQueue() {
        arr = new Integer[100];//不考虑扩容
        size = 0;
    }

    public Integer element() {
        if(size == 0) {
            throw new RuntimeException("空");
        }
        return arr[0];
    }

    public Integer remove() {
        if(size == 0) {
            throw new RuntimeException("空");
        }
        int e = arr[0];
        arr[0] = arr[size - 1];
        size--;
        adjustDown(0);
        return e;
    }
    private void adjustDown(int index) {//向下调整
        while (true) {
            int leftIndex = 2 * index + 1;
            int rightIndex = leftIndex + 1;
            //判断有无左孩子
            if (leftIndex >= size) {
                return;
            }
            //找到最小值的下标
            int minIndex = leftIndex;
            if (rightIndex < size && arr[rightIndex] < arr[leftIndex]) {
                minIndex = rightIndex;
            }
            //比较大小
            if (arr[index] <= arr[minIndex]) {
                return;
            }
            //交换
            int t = arr[index];
            arr[index] = arr[minIndex];
            arr[minIndex] = t;
            //循环
            index = minIndex;
        }
    }
    //O(log(n))
    public void add(Integer e) {//插入
        arr[size] = e;
        size++;
        adjustUp(size - 1);//从最后一个开始向上调整
    }
    public void adjustUp(int index) {//向上调整
        int parentIndex = (index - 1)/2;
        while(index != 0) {
            if(index >= size) {
                return;
            }
            if(arr[index] >= arr[parentIndex]) {
                return;
            }
            int t = arr[index];
            arr[index] = arr[parentIndex];
            arr[parentIndex] = t;

            index = parentIndex;
        }
    }
    public static int last(int[] stones) {
        int index = stones.length - 1;
        for(int i = 0; i < index; i++) {
            Arrays.sort(stones);
            if(stones[index] - stones[index-1] == 0 ) {
                stones[index - 1] = 0;
            } else {
                stones[index - 1] = stones[index] - stones[index-1];
                stones[index] = 0;
            }
        }
        return stones[stones.length - 1];
    }
    public static void main(String[] args) {
        int[] arr = {1,5,3,6,7,9};
        int a = last(arr);
        System.out.println(a);
        /*MyPriorityQueue queue = new MyPriorityQueue();
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);
        System.out.println(queue.remove());//2
        System.out.println(queue.remove());//3
        System.out.println(queue.remove());//5
        System.out.println(queue.remove());//7*/
    }
}

