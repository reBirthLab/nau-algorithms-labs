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

import java.util.Objects;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class List {

    private int lastElementIdx;
    private final Integer[] array;

    public List(int listLength) {
        this.array = new Integer[listLength];
        this.lastElementIdx = -1;
    }

    public boolean add(Integer element) {
        if (isFull()) {
            return false;
        } else {
            array[++lastElementIdx] = element;
            return true;
        }
    }

    public Integer removeByValue(Integer element) {
        if (isEmpty()) {
            return null;
        }

        Integer deletedElement = null;
        
        for (int i = 0; i <= lastElementIdx; i++) {
            if (Objects.equals(array[i], element)) {
                for (int j = i; j <= lastElementIdx; j++) {
                    array[j] = array[j + 1];
                }
                --lastElementIdx;
                deletedElement = element;
            }
        }
        return deletedElement;
    }

    public Integer removeByIndex(int index) {
        if (isEmpty()) {
            return null;
        }
        
        if (index <= lastElementIdx) {
            Integer deletedElement = array[index];

            for (int i = index; i < lastElementIdx; i++) {
                array[i] = array[i + 1];
            }
            
            array[lastElementIdx] = null;
            --lastElementIdx;

            return deletedElement;
        } else {          
            return null;
        }
    }

    public boolean isFull() {
        return lastElementIdx == array.length - 1;
    }

    public boolean isEmpty() {
        return lastElementIdx == -1;
    }

    public int listLength() {
        return array.length;
    }

    public int getLastElementIdx() {
        return lastElementIdx;
    }

    public Integer getElement(int index) {
        if (index <= lastElementIdx) {
            return array[index];
        } else {
            return null;
        }
    }

    public Integer[] toArray() {
        return array;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Index " + i + ": " + array[i]);
        }
    }
}
