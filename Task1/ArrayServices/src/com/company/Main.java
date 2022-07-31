package com.company;
import java.util.Scanner;

class ArrayService {

    private int[] arr;
    private int size;

    public void arrayInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter array's length: ");
        size = in.nextInt();
        arr = new int[size];
        System.out.println("Enter array's elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
    }

    public void arrayOutput() {
        System.out.println("Array is on display: ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

    public void arraySum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + arr[i];
        }
        System.out.println("\nArray's sum = " + sum);
    }

    public void evenNumbers() {
        int even = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] % 2 == 0) even++;
        }
        System.out.println("Even numbers: " + even);
    }

    public void segmentNumbers() {
        int a, b, segment = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter borders of segment: ");
        a = in.nextInt();
        b = in.nextInt();
        for (int i = 0; i < size; i++) {
            if((arr[i] >= a) && (arr[i] <= b)) segment++;
        }
        System.out.println("Numbers from segment: " + segment);
    }

    public void negativeNumbers() {
        boolean flag = false;

        for (int i = 0; i < size; i++) {
            if(arr[i] < 0) {flag = false; break;}
            else {flag = true;}
        }
        if (!flag) {System.out.println("There are negative elements in the array.");}
    }

    public void reverseNumbers() {
        int temp, n = size;
        for (int i = 0; i < n/2; i++) {
            temp = arr[n-i-1];
            arr[n-i-1] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Reverse array: ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        ArrayService arr = new ArrayService();
        arr.arrayInput();
        arr.arrayOutput();
        arr.arraySum();
        arr.evenNumbers();
        arr.segmentNumbers();
        arr.negativeNumbers();
        arr.reverseNumbers();
    }
}
