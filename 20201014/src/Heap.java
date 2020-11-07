import java.util.Arrays;

public class Heap {

    public static void adjustDown(int[] arr,int index,int size) {
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
    public static void creatHeap(int[] arr,int size) {
        //找到最后一个节点的下标
        int lastIndex = size - 1;
        //找到最后一个父节点的下标
        int lastParentIndex = (lastIndex - 1)/2;
        //从[lastParentaIndex,0]不断向下调整
        for(int i = lastParentIndex; i >= 0;i--) {
            adjustDown(arr,size,i);
        }
    }
    //数组，有效数组的个数，下标
    public static void adjustUp(int[] arr,int index,int size) {
        while (index != 0) {
            int rootIndex = (index - 1) / 2;
            if (arr[index] > arr[rootIndex]) {
                int t = arr[index];
                arr[index] = arr[rootIndex];
                arr[rootIndex] = t;
            } else {
                return;
            }
            index = rootIndex;
        }
    }

    public static void add(int[] arr,int size,int e) {
       arr[size] = e;
       size++;

    }

    public static void up(int[] arr,int size,int index) {
        while(true) {
            int leftIndex = 2*index + 1;
            int rightIndex = 2*index + 2;
            if(leftIndex >= size) {
                return;
            }
            int minIndex = leftIndex;
            if(rightIndex < size && arr[leftIndex] > arr[rightIndex]) {
                minIndex = rightIndex;
            }
            if(arr[index] <= arr[minIndex]) {
                return;
            }
            int t = arr[index];
            arr[index] = arr[minIndex];
            arr[minIndex] = t;

            index = minIndex;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,7,4,6,5};
        //creatHeap(arr,6);
        //System.out.println(Arrays.toString(arr));


     /*   ListNode current = head;
        while(current != null) {
            ListNode currentNext = current.next;
            ListNode newNode = new ListNode(current.val);
            current.next = newNode;
            newNode.next = currentNext;
            newNode = currentNext;*/
      /*
        ListNode oldCur = head;
        while(oldCur != null) {
            ListNode newCur = oldCur.next;
            oldCur = newCur.next;
        }*/




        }
    }

