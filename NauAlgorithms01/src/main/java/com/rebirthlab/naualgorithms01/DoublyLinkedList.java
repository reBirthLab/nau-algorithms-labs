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

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class DoublyLinkedList {

    private Element head, tail;

    public Element getHeadElement() {
        return head;
    }

    public Element getTailElement() {
        return tail;
    }

    public void setHeadElement(Element newElement) {
        if (head == null) {
            head = newElement;
            tail = newElement;
            newElement.setPreviousElement(null);
            newElement.setNextElement(null);
        } else {
            insertBefore(head, newElement);
        }
    }

    public void setTailElement(Element newElement) {
        if (tail == null) {
            setHeadElement(newElement);
        } else {
            insertAfter(tail, newElement);
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }

    public void insertBefore(Element element, Element newElement) {
        newElement.setPreviousElement(element.getPreviousElement());
        newElement.setNextElement(element);

        if (element.getPreviousElement() == null) {
            head = newElement;
        } else {
            element.getPreviousElement().setNextElement(newElement);
        }

        element.setPreviousElement(newElement);
    }

    public void insertAfter(Element element, Element newElement) {
        newElement.setPreviousElement(element);
        newElement.setNextElement(element.getNextElement());

        if (element.getNextElement() == null) {
            tail = newElement;
        } else {
            element.getNextElement().setPreviousElement(newElement);
        }

        element.setNextElement(newElement);
    }

    public String remove(Element element) {
        if (isEmpty()) {
            return null;
        }

        if (element.getPreviousElement() == null) {
            head = element.getNextElement();
        } else {
            element.getPreviousElement().setNextElement(element.getNextElement());
        }

        if (element.getNextElement() == null) {
            tail = element.getPreviousElement();
        } else {
            element.getNextElement().setPreviousElement(element.getPreviousElement());
        }

        return element.getData();
    }

    public String removeByValue(String value) {
               
        if (isEmpty() || !isInteger(value, 10)) {
            return null;
        }

        int counter = 0;
        Element currentElement = head;

        while (currentElement != null) {
            if (currentElement.getData().equals(value)) {
                remove(currentElement);
                currentElement = currentElement.getPreviousElement();
                ++counter;
            }
            currentElement = currentElement.getNextElement();
        }

        return "Element " + value + " has been deleted " + counter + " times.";
    }

    public void print() {
        int count = 0;
        Element currentElement = head;

        while (currentElement != null) {
            System.out.println("Element " + count + ": " + currentElement.getData());
            currentElement = currentElement.getNextElement();
            ++count;
        }
    }
    
    public boolean incrementalSort() {
        if (isEmpty()) {
            return false;
        }

        Element currentElement = head;
        while (currentElement.getNextElement() != null) {

            Integer currentElementData = Integer.valueOf(currentElement.getData());
            Integer nextElementData = Integer.valueOf(currentElement.getNextElement().getData());

            if (currentElementData > nextElementData) {
                insertBefore(currentElement, new Element(nextElementData.toString()));
                remove(currentElement.getNextElement());
                currentElement = head;
            } else {
                currentElement = currentElement.getNextElement();
            }
        }
        return true;
    }

    private boolean isInteger(String s, int radix) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (Character.digit(s.charAt(i), radix) < 0) {
                return false;
            }
        }
        return true;
    }
}
