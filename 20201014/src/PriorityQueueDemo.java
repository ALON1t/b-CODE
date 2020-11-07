import java.util.PriorityQueue;

public class PriorityQueueDemo {//小堆
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);
        System.out.println(queue.remove());//2
        System.out.println(queue.remove());//3
        System.out.println(queue.remove());//5
        System.out.println(queue.remove());//7
    }
}
