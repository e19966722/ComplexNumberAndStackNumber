package com.company;


import java.util.Scanner;

public class ComplexNumber {

    private final double realNumber;
    private final double imaginaryNumber;

    public ComplexNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.print("real number = ");
        realNumber = scan.nextInt();
        System.out.println();
        System.out.print("imaginary number = ");
        imaginaryNumber = scan.nextInt();

    }

    public ComplexNumber(double realNumber, double imaginaryNumber) {
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    public double getImaginaryNumber() {
        return imaginaryNumber;
    }

    public double getRealNumber() {
        return realNumber;
    }

    private String symbol() {
        if (imaginaryNumber > 0) return " + ";
        else return " - ";
    }

    public String getComplexNumber() {
        String string;
        if (imaginaryNumber == -1.0 || imaginaryNumber == 1.0) {
            if (realNumber == 0) {
                string = symbol() + "i";
            } else {
                string = realNumber + symbol() + "i";
            }
        } else if (imaginaryNumber != 0) {
            if (realNumber == 0) {
                string = imaginaryNumber + "i";
            } else {
                string = realNumber + symbol() + Math.abs(imaginaryNumber) + "i";
            }
        } else {
            string = realNumber + "";

        }
        return string;

    }


    public static ComplexNumber sum(ComplexNumber z1, ComplexNumber z2) {
        return new ComplexNumber(z1.getRealNumber() + z2.getRealNumber(), z1.getImaginaryNumber() + z2.getImaginaryNumber());
    }

    public static ComplexNumber subtract(ComplexNumber z1, ComplexNumber z2) {
        return new ComplexNumber(z1.getRealNumber() - z2.getRealNumber(), z1.getImaginaryNumber() - z2.getImaginaryNumber());
    }

    public static ComplexNumber multiply(ComplexNumber z1, ComplexNumber z2) {
        return new ComplexNumber(z1.getRealNumber() * z2.getRealNumber() - z1.getImaginaryNumber() * z2.getImaginaryNumber(), z1.getRealNumber() * z2.getImaginaryNumber() + z1.getImaginaryNumber() * z2.getRealNumber());
    }

    public static ComplexNumber divide(ComplexNumber z1, ComplexNumber z2) {
        double denominator = Math.pow(z2.getRealNumber(), 2) + Math.pow(z2.getImaginaryNumber(), 2);
        double divideReal = (z2.getRealNumber() * z1.getRealNumber() + z1.getImaginaryNumber() * z2.getImaginaryNumber());
        double divideImaginary = (z1.getImaginaryNumber() * z2.getRealNumber() - z1.getRealNumber() * z2.getImaginaryNumber());
        return new ComplexNumber(divideReal / denominator, divideImaginary / denominator);
    }

    public static void main(String[] args) {

        ComplexNumber z1 = new ComplexNumber();
        ComplexNumber z2 = new ComplexNumber();
        ComplexNumber sum, subtract, multiply, divide;
        sum = ComplexNumber.sum(z1, z2);
        System.out.println("(" + z1.getComplexNumber() + ")+(" + z2.getComplexNumber() + ") = " + sum.getComplexNumber());
        subtract = ComplexNumber.subtract(z1, z2);
        System.out.println("(" + z1.getComplexNumber() + ")-(" + z2.getComplexNumber() + ") = " + subtract.getComplexNumber());
        multiply = ComplexNumber.multiply(z1, z2);
        System.out.println("(" + z1.getComplexNumber() + ")*(" + z2.getComplexNumber() + ") = " + multiply.getComplexNumber());
        divide = ComplexNumber.divide(z1, z2);
        System.out.println("(" + z1.getComplexNumber() + ")*(" + z2.getComplexNumber() + ") = " + divide.getComplexNumber());

    }

}
