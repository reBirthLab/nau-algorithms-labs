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

import java.util.Objects;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class Square {

    private final Point vertex0;
    private final Point vertex1;
    private final Point vertex2;
    private final Point vertex3;
    private final int side;

    public Square(int side, int startPointX, int startPointY) {
        this.side = side;
        vertex0 = new Point(startPointX, startPointY);

        vertex1 = new Point();
        vertex1.setX(vertex0.getX() + side);
        vertex1.setY(vertex0.getY());

        vertex2 = new Point();
        vertex2.setX(vertex1.getX());
        vertex2.setY(vertex1.getY() - side);

        vertex3 = new Point();
        vertex3.setX(vertex0.getX());
        vertex3.setY(vertex2.getY());
    }

    public Point getVertex0() {
        return vertex0;
    }

    public int getSide() {
        return side;
    }

    public int getArea() {
        return (int) Math.pow((double) side, 2);
    }

    public int getPerimeter() {
        return side * 4;
    }

    public void printCoordinates() {
        System.out.print("A(" + vertex0.getX() + "," + vertex0.getY() + ") "
                + "B(" + vertex1.getX() + "," + vertex1.getY() + ") "
                + "C(" + vertex2.getX() + "," + vertex2.getY() + ") "
                + "D(" + vertex3.getX() + "," + vertex3.getY() + ")");
    }

    @Override
    public boolean equals(Object obj) {
        return vertex0.equals(((Square) obj).getVertex0()) && side == ((Square) obj).getSide();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.vertex0);
        hash = 71 * hash + Objects.hashCode(this.vertex1);
        hash = 71 * hash + Objects.hashCode(this.vertex2);
        hash = 71 * hash + Objects.hashCode(this.vertex3);
        hash = 71 * hash + this.side;
        return hash;
    }

}
