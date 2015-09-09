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
package com.rebirthlab.naualgorithms03;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class BinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public boolean addNode(Student student) {
        Node newNode = new Node(student);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            Node currentNode = root;
            Node parent;

            while (true) {
                parent = currentNode;

                int currentKey = currentNode.getObject().getKey();
                int newKey = newNode.getObject().getKey();

                if (newKey < currentKey) {
                    currentNode = currentNode.getLeft();

                    if (currentNode == null) {
                        parent.setLeft(newNode);
                        return true;
                    }
                } else {
                    currentNode = currentNode.getRight();

                    if (currentNode == null) {
                        parent.setRight(newNode);
                        return true;
                    }
                }
            }
        }
    }

    public void inOrderPrintAll(Node currentNode) {
        if (currentNode != null) {

            inOrderPrintAll(currentNode.getLeft());

            System.out.println("[Node] " + currentNode.getObject().toString());

            inOrderPrintAll(currentNode.getRight());
        }
    }

    public boolean removeWithCriteria(Node currentNode, int studentClass, String hobby) {
        if (currentNode != null) {

            boolean foundLeft = removeWithCriteria(currentNode.getLeft(), studentClass, hobby);

            int currentNodeStudentClass = currentNode.getObject().getStudentClass();
            String currentNodeHobby = currentNode.getObject().getHobby();

            boolean foundHere;
            if (currentNodeStudentClass == studentClass && currentNodeHobby.equals(hobby)) {
                remove(currentNode.getObject().getKey());
                System.out.println("[Removed Node] " + currentNode.getObject().toString());
                foundHere = true;
            } else {
                foundHere = false;
            }

            boolean foundRight = removeWithCriteria(currentNode.getRight(), studentClass, hobby);

            return foundHere || foundLeft || foundRight;
        }

        return false;
    }

    public boolean remove(int key) {
        Node parent = root;
        Node currentNode = root;
        boolean isLeft = true;

        while (currentNode.getObject().getKey() != key) {
            parent = currentNode;

            if (key < currentNode.getObject().getKey()) {
                isLeft = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeft = false;
                currentNode = currentNode.getRight();
            }
        }

        if (currentNode == null) {
            return false;
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == root) {
                root = null;
            } else if (isLeft) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }

        } else if (currentNode.getRight() == null) {
            if (currentNode == root) {
                root = currentNode.getLeft();
            } else if (isLeft) {
                parent.setLeft(currentNode.getLeft());
            } else {
                parent.setRight(currentNode.getLeft());
            }
        } else if (currentNode.getLeft() == null) {
            if (currentNode == root) {
                root = currentNode.getRight();
            } else if (isLeft) {
                parent.setLeft(currentNode.getRight());
            } else {
                parent.setRight(currentNode.getRight());
            }
        } else {
            Node replacement = getReplacementNode(currentNode);

            if (currentNode == root) {
                root = replacement;
            } else if (isLeft) {
                parent.setLeft(replacement);
            } else {
                parent.setRight(replacement);
            }
            replacement.setLeft(currentNode.getLeft());
        }

        return true;
    }

    private Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node currentNode = replacedNode.getRight();

        while (currentNode != null) {
            replacementParent = replacement;
            replacement = currentNode;
            currentNode = currentNode.getLeft();
        }

        if (replacement != replacedNode.getRight()) {
            replacementParent.setLeft(replacement.getRight());
            replacement.setRight(replacedNode.getRight());
        }
        return replacement;
    }
}
