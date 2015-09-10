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

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class StudentsArray {

    private final Student[] array;
    private int lastIndex = -1;

    public StudentsArray(int length) {
        array = new Student[length];

        for (Student student : array) {
            add(new Student());
        }
    }

    public boolean interpolationSearchFor(int recordBookId, boolean hasMilitaryTraining) {
        int counter = 0;
        int low = 0;
        int high = array.length - 1;

        while (low != high && array[low].hasMilitaryTraining() != array[high].hasMilitaryTraining()) {
            int mid = (low + high) / 2;

            if (array[mid].hasMilitaryTraining() == hasMilitaryTraining
                    && array[mid].getRecordBookId() == recordBookId) {
                System.out.println("[Match] " + array[mid]);
                System.out.println("Result found in " + counter + " steps.");
                return true;
            } else if (array[low].hasMilitaryTraining() != array[mid].hasMilitaryTraining()
                    && array[mid].hasMilitaryTraining() == hasMilitaryTraining) {
                ++low;
            } else if (array[low].hasMilitaryTraining() == array[mid].hasMilitaryTraining()
                    && array[mid].hasMilitaryTraining() != hasMilitaryTraining) {
                ++low;
            } else {
                --high;
            }
            ++counter;
        }

        for (int i = low; i <= high; i++) {
            if (array[i].hasMilitaryTraining() == hasMilitaryTraining
                    && array[i].getRecordBookId() == recordBookId) {
                System.out.println("[Match] " + array[i]);
                System.out.println("Result found in " + counter + " steps.");
                return true;
            }
            ++counter;
        }

        return false;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Index " + i + ": " + array[i]);
        }
        System.out.println();
    }

    private boolean add(Student student) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].hasMilitaryTraining() == student.hasMilitaryTraining()) {
                    if (!isFull()) {
                        // Insert student if there is coincidence of criteria
                        for (int j = lastIndex; j >= i; j--) {
                            array[j + 1] = array[j];
                        }

                        array[i] = student;
                        ++lastIndex;
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                // Add student if current slot is empty
                array[i] = student;
                ++lastIndex;
                return true;
            }
        }
        return false;
    }

    private boolean isFull() {
        return lastIndex == array.length - 1;
    }
}
