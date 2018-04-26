package algorithms;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int HUNDRED = 100;

        for(int i = 0; i < HUNDRED; i++) {
            binaryTree.addNode(random.nextInt(HUNDRED));
        }

        System.out.println("The Tree: ");
        binaryTree.inOrderTraverseChanged(binaryTree.getRoot());
        System.out.println();

        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("Your number in Tree is ");
        if(binaryTree.findNode(number) != null) {
            Node currentNode = binaryTree.findNode(number);
            while(true){
                if(currentNode.getLeftSide() != null){
                    currentNode = currentNode.getLeftSide();
                }
                else if(currentNode.getRightSide() != null){
                    currentNode = currentNode.getRightSide();
                }
                else {
                    break;
                }
            }
            System.out.println("Counter of the " + currentNode.getKey() + " equals " + currentNode.getCounter());
        } else {
            System.out.println("Tree has no that number, the path would be ");
            binaryTree.addNode(number);
            System.out.println(binaryTree.recoveringPathToNode(number));
            binaryTree.removeNode(number);
        }
        //binaryTree.inOrderTraverse(binaryTree.getRoot());
        //binaryTree.preOrderTraverse(binaryTree.getRoot());
        //binaryTree.postOrderTraverse(binaryTree.getRoot());
    }
}
