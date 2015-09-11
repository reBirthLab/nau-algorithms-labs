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
package com.rebirthlab.naualgorithms06;

import java.util.Random;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class DataArray {

    private final Random rand = new Random();

    private final double[] arrayOriginal;
    private final int arrayLength;

    public DataArray(int arrayLength) {
        this.arrayLength = arrayLength;
        arrayOriginal = new double[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            arrayOriginal[i] = rand.nextDouble();
        }
    }

    public void print() {
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("[Index " + i + "] " + arrayOriginal[i]);
        }
        System.out.println();
    }

    // Top-down Merge sort
    public double[] topDownMergeSort() {
        double[] arrayCopy = new double[arrayLength];
        double[] arrayTemp = new double[arrayLength];
        System.arraycopy(arrayOriginal, 0, arrayCopy, 0, arrayLength);

        topDownMergeSortSplit(arrayCopy, 0, arrayLength - 1, arrayTemp);
        return arrayCopy;
    }

    private void topDownMergeSortSplit(double[] arrayCopy, int start, int end, double[] arrayTemp) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            topDownMergeSortSplit(arrayCopy, start, middle, arrayTemp);
            topDownMergeSortSplit(arrayCopy, middle + 1, end, arrayTemp);
            merge(arrayCopy, start, middle, end, arrayTemp);
        }
    }

    // Bottom-up Merge sort
    public double[] bottomUpMergeSort() {
        double[] arrayCopy = new double[arrayLength];
        double[] arrayTemp = new double[arrayLength];
        System.arraycopy(arrayOriginal, 0, arrayCopy, 0, arrayLength);

        for (int width = 1; width < arrayLength; width = 2 * width) {
            for (int i = 0; i < arrayLength - width; i = i + 2 * width) {
                int start = i;
                int middle = i + width - 1;
                int end = Math.min(i + 2 * width - 1, arrayLength - 1);

                merge(arrayCopy, start, middle, end, arrayTemp);
            }
        }

        return arrayCopy;
    }

    // Common function
    private void merge(double[] arrayCopy, int start, int middle, int end, double[] arrayTemp) {
        for (int i = start; i <= end; i++) {
            arrayTemp[i] = arrayCopy[i];
        }

        int i = start;
        int j = middle + 1;
        int k = start;

        while (i <= middle && j <= end) {
            if (arrayTemp[i] <= arrayTemp[j]) {
                arrayCopy[k] = arrayTemp[i];
                i++;
            } else {
                arrayCopy[k] = arrayTemp[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            arrayCopy[k] = arrayTemp[i];
            k++;
            i++;
        }
    }

}
