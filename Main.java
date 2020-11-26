import java.util.Scanner;

public class Main {

    public static int count(int[] arr, int x){
        int count = 0;
        if( x <= 1) {
            return 0;
        }
        int s = 0;
        int y = 0;
        while(x >= 2) {
            if(x == 2) {
                x = x + 1;
            }
            s = x / 3;
            y = x % 3;
            x = s + y;
            count = count + s;
        }
        return count;
    }
    public static int count1(int[] A, int n) {
        // write code here
        int count = 0;
        int i = 0;

        for(i = 0; i < n ;i++) {
            for(int j = i + 1; j < n ;j++) {
                if(A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }/**
     题目：读入一个字符串str，输出字符串str中的连续最长的数字串
     输入描述:
     个测试输入包含1个测试用例，一个字符串str，长度不超过255。

     输出描述:
     在一行内输出str中里连续最长的数字串。
     示例1
     输入
     abcd12345ed125ss123456789
     输出
     123456789
     */
    public static void  mostLong(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        String ret = "";
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9') {
                count = 1;
                int indexI = i;
                int indexJ = i;
                for(int j = i+1; j < chars.length; j++) {
                    if(chars[j] >= '0' && chars[j] <= '9') {
                        count++;
                        indexJ = j;
                    } else {
                        break;
                    }
                }
                if(count > ret.length()) {
                    ret = str.substring(indexI,indexJ + 1);
                }
            }
        }
        System.out.println(ret);
    }
    public static boolean chkParenthesis(String A, int n) {
        // write code here
        char[] chars = A.toCharArray();
        if(n % 2 != 0) {
            return false;
        }
        int count1 = 0;
        for(int i = 0; i < n;i++) {
            if(chars[i] != '(' && chars[i] != ')') {
                return false;
            }
            if(chars[i] == '(') {
                count1++;
            }
        }
        if(count1 != n / 2) {
            return false;
        }
        if(chars[0] == ')' || chars[n - 1] == '(') {
            return false;
        }

        return true;
    }

    public static int minD(int n) {
        if (n % 2 == 1 || n < 6 || n > 100) {
            return -1;
        }
        if (n == 6 || n == 8) {
            return 1;
        }
        if (n % 8 == 0) {
            return n / 8;
        }
        int x = 0;//8
        int y = 0;//6
        //int i = n / 8;
        for(int i = n/8;i > 0; i--) {
            if((n - 8 * i) % 6 != 0) {
                x = i;
                y = (n - 8*i)/6;
            } else {
                return i + 1;
            }
        }
        return x + y;
    }

    public static void fun(String str1,String str2) {

        for (int i = 0;i < str1.length();i++) {
            int j = 0;
            for (;j < str2.length();j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    str1 = str1.substring(0,i)+str1.substring(i+1);
                    break;
                }
            }
        }
        System.out.println(str1);
    }
    public static  void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int ret = minD(n);
            System.out.println(ret);
        }


//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        mostLong(str);
        /*String str = "(()()))";
        System.out.println(chkParenthesis(str, 7));*/

        /*String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println(str1==str2);
        int i = 0;*/

        /*int[] arr = {1,2,3,4,5,6,7,0};
        int ret = count1(arr,8);
        System.out.println(ret);*/
        /*Scanner scanner = new Scanner(System.in);

        int[] arr = {};
        int i = 0;

        while(scanner.hasNext()) {
            int x = scanner.nextInt();
            arr[i] = x;
            i++;
            if(x == 00) {
                break;
            }
        }
        int ret = count(arr,arr.length);
        System.out.println(ret);*/
        /**
         * Scanner scanner = new Scanner(System.in);
         *         int n = scanner.nextInt();
         *         int[] arr = new int[n];
         *         int i = 0;
         *         while(i < n && scanner.hasNext()) {
         *             int x = scanner.nextInt();
         *             arr[i] = x;
         *             i++;
         *         }
         *         int ret = count(arr,n);
         *         System.out.println(ret);
         * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
         * 小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
         * 方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，
         * 用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先
         * 借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
         * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
         *
         * 输入描述:
         * 输入文件最多包含10组测试数据，每个数据占一行，
         * 仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。
         * n=0表示输入结束，你的程序不应当处理这一行。
         * 输出描述:
         * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
         */
//        Scanner scanner = new Scanner(System.in);
//        int n = 0;
//        int[] arr = new int[10];
//        int i = 0;
//        while(i < 10 && scanner.hasNext()) {
//
//            int x = scanner.nextInt();
//            if(x == 0) {
//                break;
//            }
//            arr[i] = x;
//            i++;
//            n++;
//        }
//        for(i = 0; i < n; i++) {
//            int ret = count(arr[i]);
//            System.out.println(ret);
//        }
        /*while(n <= 10 && scanner.hasNext()) {
            int x = scanner.nextInt();
            int ret = count(x);
            System.out.println(ret);
            n++;
        }*/
    }
}
