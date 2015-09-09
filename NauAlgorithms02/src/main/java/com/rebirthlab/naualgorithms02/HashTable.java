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

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class HashTable {

    private class HashTableSquare {

        Square object;
        HashTableSquare next;

        public HashTableSquare(Square square) {
            object = square;
        }
    }

    private final HashTableSquare[] array;
    private final int tableSize;

    public HashTable(int tableSize) {
        this.tableSize = tableSize;
        array = new HashTableSquare[tableSize];
    }

    public boolean insert(Square square) {
        int idx = getIndex(square);
        if (array[idx] == null) {
            array[idx] = new HashTableSquare(square);
            return true;
        } else {
            return resolveCollision(array[idx], new HashTableSquare(square));
        }
    }
  
    public void removeSquareWithAreaLessThan(int area) {
        for (int i = 0; i < tableSize; i++) {
            if (array[i] != null) {
                HashTableSquare currentObject = array[i];
                while (currentObject != null) {
                    if (currentObject.next != null && currentObject.next.object.getArea() <= area) {
                        removeObjectAfter(currentObject);
                    }
                    currentObject = currentObject.next;
                }

                if (array[i].object.getArea() <= area) {
                    removeFirstObject(i);
                }
            }
        }
    }

    public void print() {
        System.out.println("***HASH TABLE***");
        for (int i = 0; i < tableSize; i++) {
            System.out.println("[Index " + i + "]");
            if (array[i] != null) {
                HashTableSquare currentObject = array[i];
                do {
                    System.out.print("Perimeter (Key): " + currentObject.object.getPerimeter() + ", ");
                    System.out.print("Area: " + currentObject.object.getArea() + ", ");
                    currentObject.object.printCoordinates();
                    System.out.println("; ");

                    currentObject = currentObject.next;
                } while (currentObject != null);
            } else {
                System.out.println("There are no objects.");
            }
            System.out.println();
        }
    }

    private boolean resolveCollision(HashTableSquare existingObject, HashTableSquare newObject) {
        HashTableSquare currentObject = existingObject;
        while (currentObject != null && !currentObject.object.equals(newObject.object)) {
            if (currentObject.next == null) {
                currentObject.next = newObject;
                return true;
            } else {
                currentObject = currentObject.next;
            }
        }
        return false;
    }

    private int getIndex(Square square) {
        return square.getPerimeter() % array.length;
    }
    
    private boolean removeObjectAfter(HashTableSquare square) {
        if (square.next == null) {
            return false;
        }

        square.next = square.next.next;
        return true;
    }

    private boolean removeFirstObject(int index) {
        if (array[index] == null) {
            return false;
        }

        array[index] = array[index].next;
        return true;
    }
}
