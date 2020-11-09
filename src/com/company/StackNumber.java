package com.company;

import java.util.Random;
import java.util.Scanner;

public class StackNumber {
    private final int size;
    private final int[] stackArrayNumber;
    private int index;

    public StackNumber(int size) {
        this.size = size;
        stackArrayNumber = new int[size];
        index = -1;

    }

    public void addStack(int number) {
        stackArrayNumber[++index] = number;
    }

    public int deleteStack() {
        return stackArrayNumber[index--];
    }

    public boolean isEmpty() {
        return (index == -1);
    }

    public boolean isFull() {
        return (index == size - 1);
    }

    public int readIndex() {
        return stackArrayNumber[index];
    }

    public static void main(String[] args) {
        Scanner sizeArray = new Scanner(System.in);
        int size = sizeArray.nextInt();
        StackNumber stack = new StackNumber(size);
        Random random = new Random();

        while (!stack.isFull()) {
            stack.addStack(random.nextInt(50));
            System.out.print(stack.readIndex() + " ");
        }
        System.out.println();

        while (!stack.isEmpty()) {
            int value = stack.deleteStack();
            System.out.print(value + " ");
        }
    }
}

