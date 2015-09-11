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

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int N = 100;
        
        long startTime;
        long elapsedTime;

        DataArray data1 = new DataArray(N);
        DataArray data2 = new DataArray((int)Math.pow(N, 2));
        DataArray data3 = new DataArray((int)Math.pow(N, 3));       
        
        System.out.println("N = " + N + "\n");
        
        System.out.println("***Top-down Merge Sort***");
        startTime = System.nanoTime();
        double[] sortedArrayTDMS1 = data1.topDownMergeSort();
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Data of N items sorted in " + elapsedTime + " ns.");
        
        startTime = System.nanoTime();
        double[] sortedArrayTDMS2 = data2.topDownMergeSort();
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Data of N^2 items  sorted in " + elapsedTime + " ns.");
        
        startTime = System.nanoTime();
        double[] sortedArrayTDMS3 = data3.topDownMergeSort();
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Data of N^3 items sorted in " + elapsedTime + " ns.\n");
        
        System.out.println("***Bottom-up Merge Sort***");
        startTime = System.nanoTime();
        double[] sortedArrayBUMS1 = data1.bottomUpMergeSort();
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Data of N items sorted in " + elapsedTime + " ns.");
        
        startTime = System.nanoTime();
        double[] sortedArrayBUMS2 = data2.bottomUpMergeSort();
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Data of N^2 items  sorted in " + elapsedTime + " ns.");
        
        startTime = System.nanoTime();
        double[] sortedArrayBUMS3 = data3.bottomUpMergeSort();
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Data of N^3 items sorted in " + elapsedTime + " ns.");
    }
    
}
