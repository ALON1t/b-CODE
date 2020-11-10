
import java.util.Arrays;
    public class Tset {

        public static void fun(int[] arr) {

            int i = 0;
            int j = arr.length - 1;
            while (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }

    
    public static void fun1(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static void main12(String[] args) {

        String s = "hh";

        System.out.println("s="+ s);

        /*int[][] arr = {{1,2,3},{4,5,6}};
        int[][] arr1 = new int[][] {};
        System.out.println(Arrays.deepToString(arr1));
        fun1(arr);*/
        /*int[] arr = {1,5,7,6,2,4,9} ;
        fun(arr);
        System.out.println(Arrays.toString(arr));*/
    }

    public static void bubbleSort(int[] arr) {
        boolean flg = false;
        for(int i = 0; i < arr.length - 1; i++) {
            flg = false;
            for(int j = 0; j < arr.length - 1 - i  ; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flg = true;
                }
            }
            //if( !false)
            if(flg = false) {
                break;
            }
        }
    }

    public static boolean sort(int[] arr) {

        if(arr == null || arr.length == 0) {
            return false;
        }
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main11(String[] args) {

        int[] arr = {7,9,4,1,2,3,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        //System.out.println(sort(arr));
    }

    public static int[] func7(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    public static int[] func8(int[] arr,int k) {
        int[] ret = new int[2];
        for(int i = 0; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] + arr[j] == k) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
            return ret;
    }



    public static boolean func6(int[] arr) {

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main10(String[] args) {

        int[] arr = {1,5,9,3,15,68,99};
        System.out.println(func6(arr));
    }

    public static String toString(int[] arr) {
        String ret = "\"[";
        if(arr == null) {
            return  "null";
        }
        if(arr.length == 0) {
            ret += "";
        }
        for(int i = 0; i < arr.length; i++) {
            if(i < arr.length-1) {
                ret += arr[i] +"," ;
            } else {
                ret += arr[i];
            }
        }
        ret += "]\"";
        return ret;
    }

    public static void main9(String[] args) {
        int[] arr = {1,5,7,9,3,6,4};
        String ret = toString(arr);
        System.out.println(ret);
    }


        /*public static void main(String[] args){
            int[] a={1,2,3,4};
            String sum=toString(a);
            System.out.println(sum);

        }public static String toString(int[] arr){
            String ret="[";
            int i;
            for(i=0;i<arr.length;i++){
                if(i<arr.length-1){
                    ret+=arr[i]+" , ";
                }else if(i==arr.length-1){
                    ret+=arr[i]+"]";
                }

            }return ret;
        }
*/


    public static int func5(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            //int mid = (left + right) / 2;
            if(key > arr[mid]) {
                left = mid + 1;
            } else if(key < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int[] myCopyOf(int[] arr) {
        int[] arr1 = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }

    public static void main8(String[] args) {
        //int[] arr = {1,3,25,7,9,11,15};
        //int ret = func3(arr);
        //System.out.println(ret);
        int[] arr2 = {};
        System.out.println(Arrays.toString(arr2));
    }

    public static void func4(int[] arr) {
        double sum = 0;
        for(int i = 0;i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum/arr.length);
    }

    public static int func3(int[] arr) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        for(int i = 1;i < arr.length; i++) {

            if(arr[i] > max) {
                max = arr[i];
               /* int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;*/
            }
        }
         return max;
    }

    public static void main7(String[] args) {
        int[] arr = {5,4,9,2,7,1};
        System.out.println(Arrays.toString(arr));
        //int ret = func3(arr);
        //System.out.println(func3(arr));
        func4(arr);
        //System.out.println(ret);
    }

    public static int[] func(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
        return arr;
    }

    public static int[] func1(int[] arr1) {
        int[] temp = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++) {
            temp[i] = arr1[i]*2;
        }
        return temp;
    }

    public static void main6(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(func(arr)));
        System.out.println(Arrays.toString(arr));
        System.out.println();
        //System.out.println(Arrays.toString(func1(arr)));
        //System.out.println(Arrays.toString(arr));
    }

    public static int[] func() {
        int[] arr = {1,2,3,4,5};
        return arr;
    }

    public static void main5(String[] args) {

        System.out.println(Arrays.toString(func()));
    }
    public static void func(int x) {
        x = 10;
        System.out.println("x = " + x);
    }

    public static void main4(String[] args) {
        int num = 0;
        func(num);   //x = 10
        System.out.println("num = " + num);  //num = 0
    }

    public static void print(int[] arr1) {
        arr1[0] = 99;
        for(int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }

    public static void main3(String[] args) {
        int[] arr = {1,5,8,6,9,6};
        print(arr);  //99 5 8 6 9 6
        System.out.println();

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            //99 5 8 6 9 6
        }
    }
    public static void main2(String[] args) {
        int[] arr = {1,5,8,6,9,6};
        //法1
        for(int i = 0; i <= arr.length; i++) { //arr.length为数组长度
            System.out.print(arr[i] + " ");
        }
        arr = null;
        System.out.println(arr.length);

        System.out.println();
        //法2
/*        for(int x : arr) {  //int x 为数组中数据的类型，arr为数组名字
            System.out.print(x + " ");
        }
        System.out.println();
        //法3    将数组以字符串形式输出

        //System.out.println(Arrays.toString(arr));

        String str = Arrays.toString(arr);
        System.out.println(str);*/
    }


    public static void main1(String[] args) {
        int[] arr = {1,2,5,7,9}; //此时[]中不能写具体的数字
        int[] arr1 = new int[5]; //定义了一个未初始化的数组，大小为5
        int[] arr2 = new int[] {1,2,5,7,6}; //此时[]中不能写具体的数字
    }
}

 /*   public static int fbi(int n) {
        if(n <= 0) {
            return -1;
        }
        if(n == 1 || n ==2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for(int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {

        System.out.println(fbi(5));
    }
}*/

    /*public static void swap(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while(i < j) {
            while(i < j && arr[j] % 2 == 0) {
                j--;
            }
            while(i < j && arr[i] % 2 != 0) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,9,4,5,2,7,8};
        swap(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
*/