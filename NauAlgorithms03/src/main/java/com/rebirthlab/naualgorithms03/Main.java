/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebirthlab.naualgorithms03;

import com.rebirthlab.naualgorithms03.commons.Constants;
import java.util.Scanner;

/**
 *
 * @author Anastasiy Tovstik <anastasiy.tovstik@gmail.com>
 */
public class Main {

    // Variant 5
    public static void main(String[] args) {
        int number;
        int studentClass;
        String hobby;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of student you wish to add to a binary tree >>>");
        do {
            System.out.print("Please enter positive number: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number: ");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        System.out.println();

        BinaryTree tree = new BinaryTree();

        for (int i = 0; i < number; i++) {
            tree.addNode(new Student());
        }

        tree.inOrderPrintAll(tree.getRoot());

        System.out.println();
        System.out.println("Enter student class which should be removed from the tree >>>");
        do {
            System.out.print("Please enter a number beetween 1 and 5: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number: ");
                scanner.next();
            }
            studentClass = scanner.nextInt();
        } while (studentClass <= 0 || studentClass > 5);

        System.out.println();
        System.out.println("Enter student hobby witch should be removed from the tree >>>");
        do {
            System.out.print("Please enter a word (Dancing, Painting, Sport, Reading, Hikking): ");
            hobby = scanner.next();
            
            if (match(hobby)) {
                break;
            }
        } while (true);
        System.out.println();

        if (!tree.removeWithCriteria(tree.getRoot(), studentClass, hobby)) {
            System.out.println("Not found.");
        }
        
        System.out.println();

        tree.inOrderPrintAll(tree.getRoot());

    }

    private static boolean match(String chosenHobby) {
        for (Constants.HOBBIES hobby : Constants.HOBBIES.values()) {
            if (chosenHobby.equals(hobby.toString())) {
                return true;
            }
        }
        return false;
    }

}
