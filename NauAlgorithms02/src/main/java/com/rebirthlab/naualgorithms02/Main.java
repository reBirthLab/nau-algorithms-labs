/* 
 * The MIT License
 *
 * Copyright 2015 Anastasiy Tovstik <anastasiy.tovstik@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.rebirthlab.naualgorithms02;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class Main {

    private static final Random rand = new Random();

    public static Integer randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    // Variant 5
    public static void main(String[] args) {
        int size;
        int area;
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Hash table size.");
        do {
            System.out.print("Please enter positive number: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number: ");
                scanner.next();
            }
            size = scanner.nextInt();
        } while (size <= 0);

        HashTable table = new HashTable(size);

        System.out.println();

        while (repeat) {
            System.out.print("Add an object to Hash table? (Y/N) > ");
            String continueChoice = scanner.next().toUpperCase();

            if (continueChoice.equals("Y")) {
                int side = randInt(10, 100);
                int x = randInt(-100, 100);
                int y = randInt(-100, 100);

                table.insert(new Square(side, x, y));
                System.out.println("Object [Side: " + side + ", A(" + x + ", " + y + ")]"
                        + " was successfully added!");
                repeat = true;

            } else if (continueChoice.equals("N")) {
                System.out.println();
                repeat = false;

            } else {
                System.out.println("Please enter 'Y' or 'N'...");
            }
        }

        table.print();

        System.out.println("Enter minimum area of a square that should pass.");
        do {
            System.out.print("Please enter positive number: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number: ");
                scanner.next();
            }
            area = scanner.nextInt();
        } while (area <= 0);

        table.removeSquareWithAreaLessThan(area);
        
        System.out.println();
        table.print();
    }
}
