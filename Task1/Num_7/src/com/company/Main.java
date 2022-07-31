package com.company;
import java.util.Scanner;
import java.lang.Math;

public class Main{
    public static void main(String[] args) {
        double x, precision, expX = 1., result = 1;
        int i = 1;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a point:");
        x = in.nextDouble();
        System.out.println("Enter the precision:");
        precision = in.nextDouble();
        if(x > 0) {
            while (precision <= expX) {
                expX = (expX*x) / i;
                result = result + expX;
                i++;
            }
            System.out.println("Calculation result: " + result);
        }
        if(x < 0) {
            while (precision <= Math.abs(expX)){
                expX = (expX*x) / i;
                result = result + expX;
                i++;
            }
            System.out.println("Calculation result: " + result);
        }
        if(x == 0) {System.out.println("Calculation result: " + result);}
    }
}