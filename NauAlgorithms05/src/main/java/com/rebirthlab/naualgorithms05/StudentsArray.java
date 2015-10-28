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

    public boolean interpolationSearchFor(int recordBookId) {
        Student[] sortedStudentsWithMilitaryTraining = sortWithMilitaryTrainingByStudentId();

        if (sortedStudentsWithMilitaryTraining != null) {
            int matchIndex = findElement(0, sortedStudentsWithMilitaryTraining.length - 1, recordBookId, sortedStudentsWithMilitaryTraining);

            if (matchIndex != -1) {
                System.out.println("[Match] " + sortedStudentsWithMilitaryTraining[matchIndex]);
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Index " + i + ": " + array[i]);
        }
        System.out.println();
    }

    private Student[] findStudentsWithMilitaryTraining() {
        int counter = 0;
        int firstIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i].hasMilitaryTraining() && firstIndex == -1) {
                firstIndex = i;
            }

            if (array[i].hasMilitaryTraining()) {
                counter++;
            }
        }

        if (counter != 0) {
            Student[] selection = new Student[counter];

            for (int j = 0; j < selection.length; j++) {
                selection[j] = array[firstIndex];
                firstIndex++;
            }
            return selection;
        }
        return null;
    }

    private Student[] sortWithMilitaryTrainingByStudentId() {

        Student[] selection = findStudentsWithMilitaryTraining();

        if (selection != null) {

            Student temp;

            for (int i = 0; i < selection.length; i++) {
                for (int j = 1; j < (selection.length - i); j++) {
                    if (selection[j - 1].getRecordBookId() > selection[j].getRecordBookId()) {
                        temp = selection[j - 1];
                        selection[j - 1] = selection[j];
                        selection[j] = temp;
                    }
                }
            }

            System.out.println("Sorted list of students with military training:");
            for (Student st : selection) {
                System.out.println(st);
            }
            System.out.println();
            
            return selection;
        }
        return null;
    }

    private int findElement(int left, int right, int key, Student[] array) {
        if (left > right) {
            return -1;
        }

        int middle = left + (key - array[left].getRecordBookId()) * (right - left)
                / (array[right].getRecordBookId() - array[left].getRecordBookId());

        if (key == array[middle].getRecordBookId()) {
            return middle;
        }

        if (left == right) {
            return -1;
        }

        if (key < array[middle].getRecordBookId()) {
            return findElement(left, middle - 1, key, array);
        } else {
            return findElement(middle + 1, right, key, array);
        }

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
