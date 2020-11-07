package p692;

import java.io.IOException;
import java.util.List;
import java.util.*;

public class Solution {

    //public static void main(String[] args) {

            //public static void main(String[] args) throws IOException {/*
              /*  Scanner scanner = new Scanner(System.in);
                int a = scanner.nextInt();
                for(int i = 0; i < 5; i++) {
                    for(int j = 0; j < 5 - i;j++){
                        System.out.println(" ");
                    }
                    for(int k = 0; k < i; k++) {
                        System.out.println(a);
                    }
                }*/
                /*Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                System.out.print("year=" + str.substring(0,4) +"\nmonth=" +
                        str.substring(4,6) +"\ndate=" + str.substring(6))*/
                public static void swap(int a,int b) {
                    int t = a;
                    a = b;
                    b = t;
                }
    public static void print(int a){
        while (a != 0) {
            System.out.print(a % 10);
            a = a / 10;
        }
    }
    public static void swap1(int a,int b){
        int t = a;
        a = b;
        b = t;
    }
                public static void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);
                    float w = scanner.nextFloat();
                    float h = scanner.nextFloat();
                    h = h /100;
                    float bmi = w / (h * h);
                    System.out.print(String.format("%.2f",bmi));
                    /*Scanner scanner = new Scanner(System.in);
                    float a = scanner.nextFloat();
                    float b = scanner.nextFloat();
                    float c = scanner.nextFloat();
                    float sum = a + b + c;
                    float ave = sum / 3;
                    System.out.println(String.format("%.2f", sum) + " " + String.format("%.2f",ave));*/
                    /*Scanner scanner = new Scanner(System.in);
                    long seconds = scanner.nextLong();
                    long hour = seconds / 3600;
                    long min = seconds % 3600 / 60;
                    long sec = seconds % 3600 % 60;
                    if(seconds> 0 && seconds < 100000000){
                        System.out.println(hour + " " + min + " " + sec);
                    }*/

                    /*Scanner scanner = new Scanner(System.in);
                    long age = scanner.nextLong();
                    if(0 < age && age <= 200) {
                        System.out.println(age*31560000);
                    }*/

                    /*int a = (int)f;
                    while(a > 9) {
                        a = a % 10;
                    }
                    System.out.println(a);*/

                   /* Scanner scanner = new Scanner(System.in);
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    int t = a;
                    a = b;
                    b = t;
                    System.out.print("a=" + a + "," + "b=" + b);*/
                    //System.out.println(a);
                    /*Scanner scanner = new Scanner(System.in);
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    swap(a,b);
                    *//*int a = 1; int b = 2;*//*
                    System.out.println("a=" + b + "," + "b=" + a);*/
                }
            }


