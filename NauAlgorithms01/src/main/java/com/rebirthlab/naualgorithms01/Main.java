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
package com.rebirthlab.naualgorithms01;

import java.util.Random;

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
        int numberOfElements = 12;

        List list = new List(numberOfElements);

        for (int i = 0; i < numberOfElements; i++) {
            list.add(randInt(-100, 100));
        }

        System.out.println("Original List:");
        list.print();

        DoublyLinkedList linkedList = new DoublyLinkedList();

        for (int i = 0; i < numberOfElements; i++) {
            Integer currentElement = list.getElement(i);
            if (currentElement != null && currentElement.longValue() % 2 == 0) {
                linkedList.setTailElement(new Element(currentElement.toString()));
                list.removeByIndex(i);
                --i;
            }
        }

        System.out.println("\nModified List:");
        list.print();

        System.out.println("\nLinked List:");
        linkedList.print();

        linkedList.incrementalSort();

        System.out.println("\nSorted Linked List:");
        linkedList.print();

    }

}
