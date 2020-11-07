import javax.jnlp.IntegrationService;
import java.util.*;

public class test {
    private  static long T(String hexString) {
        char[] chars = hexString.toCharArray();
        long sum = 0;
        for(int i = 0; i < chars.length; i++) {
            //int digit = change(c);
            //sum = (sum + digit)*16;
        }
        return sum/16;
    }

    public  static void change(long c) {

    }
    public static void inserSort(long[] arr) {
        int j = 0;
        for(int i = 0; i < arr.length - 1; i++){
            long k = arr[i + 1];
            for(j = i; j >= 0; j--) {
                if(k >= arr[j] ){
                    break;
                } else {
                    arr[j + 1] = arr[j];
                }
            }
            arr[j + 1] = k;
        }
    }



    public static long[] suiji() {
        Random random = new Random(20201018);
        long[] arr = new long[10];
        for(int i = 0; i < 10;i++ ) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
    public static void bubbleSort(long[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1;j++) {
                if(arr[j] > arr[j+1]) {
                    long t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }
    public static void selectSort(long[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int max = 0;
            for(int j = 1; j < arr.length - i; j++) {
                if(arr[j] > arr[max]) {
                    max = j;
                }
            }
         long t = arr[max];
            arr[max] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
    }



    public static void main1(String[] args) {

        long[] arr = suiji();
        System.out.println(Arrays.toString(arr));
        //partitionWK(arr,)
        System.out.println(Arrays.toString(arr));
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
            while(leftIndex < rightIndex && key <= arr[leftIndex]) {
                leftIndex++;
            }
            long x = arr[leftIndex];
            arr[leftIndex] = arr[lowIndex];
            arr[leftIndex] = key;
        }
        return leftIndex;
    }


    public static int[] change1(long n) {
        //20201018
        //2020101  8
        //202010   1
        //20201    0
        //2020     1
        //202      0
        //20       2
        //2        0
        int count = 0;
        long x = n;
        while(x != 0) {
            x /= 10;
            count++;
        }
        int[] arr = new int[count];
        for(int i = count-1; i >= 0;i--) {
            arr[i] = (int)n%10;
            n /= 10;
        }
        return arr;
    }

//    public static int[] change2(long n ) {
//
//    }

    public  static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> lists = new ArrayList<>();

        if(nums1.length == 0 || nums2.length == 0) {
            return lists;
        }
        if(k > nums1.length*nums2.length) {
            k = nums1.length*nums2.length;
        }
        int[][] arr = new int[nums1.length*nums2.length][];
        int index = 0;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                arr[index][0] = nums1[i];
                arr[index][1] = nums2[j];
                index++;
            }
        }
        Arrays.sort(arr,(o1, o2) -> (o1[0] + o1[1] - (o2[0] - o2[1])));
        for(int i = 0;i < k; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i][0]);
            list.add(arr[i][1]);
            lists.add(list);
        }
        return lists;
    }

/*    public int[] twoSum(int[] nums, int target) {

        int i = 0;
        for(; i < nums.length; i++) {
           Integer x = target - nums[i];
            if(map.containsKey(x)) {
                int y = map.get(x);
                return new int[] {y,i};
            }
            map.put(nums[i],i);
        }
        return new int[] {0,0};
    }*/

    public static void fun() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        char[] chars = str.toCharArray();
        Set<Character> set = new TreeSet<>();

        for(int i = 0; i < chars.length; i++) {
           if(set.contains(chars[i])) {
              break;
           }
           set.add(chars[i]);
        }
    }




    public static void main(String[] args) {
        long n = 20201018;
        int[] arr = change1(n);
        System.out.println(Arrays.toString(arr));
    }

}
