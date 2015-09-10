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

import com.rebirthlab.naualgorithms05.commons.Constants;
import com.rebirthlab.naualgorithms05.commons.RandomNumber;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class Student {

    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final int recordBookId;
    private final boolean militaryTraining;

    public Student() {
        firstName = Constants.FIRST_NAMES.values()[RandomNumber.randInt(0, 9)].toString();
        lastName = Constants.LAST_NAMES.values()[RandomNumber.randInt(0, 9)].toString();
        middleName = Constants.MIDDLE_NAMES.values()[RandomNumber.randInt(0, 4)].toString();
        recordBookId = RandomNumber.randInt(1000, 5000);
        militaryTraining = RandomNumber.rand.nextBoolean();
    }

    public int getRecordBookId() {
        return recordBookId;
    }

    public boolean hasMilitaryTraining() {
        return militaryTraining;
    }

    @Override
    public String toString() {
        return "Student: " + firstName + " " + middleName + " " + lastName
                + " Record book ID: " + recordBookId + " Military Training: " + convertBoolean(militaryTraining);
    }

    private String convertBoolean(boolean bool) {
        return bool ? "Yes" : "No";
    }

}
