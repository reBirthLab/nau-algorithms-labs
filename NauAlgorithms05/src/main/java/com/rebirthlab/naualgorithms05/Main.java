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
package com.rebirthlab.naualgorithms05;

import java.util.Scanner;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        int number;
        int recordBookId;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students you wish to create >>>");
        do {
            System.out.print("Please enter a positive number: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number: ");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        System.out.println();
        
        StudentsArray array = new StudentsArray(number);
        
        array.print();
        
        System.out.println("Does student with military training have the spicified Record book ID?");
        System.out.println("Enter student's Record book ID number >>>");
        do {
            System.out.print("Please enter a positive number: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number: ");
                scanner.next();
            }
            recordBookId = scanner.nextInt();
        } while (recordBookId <= 0);
        System.out.println();
        
        
        if(!array.interpolationSearchFor(recordBookId)){
            System.out.println("The student with Record book ID #" + recordBookId + " has no military training.");
        }  
    }

}
