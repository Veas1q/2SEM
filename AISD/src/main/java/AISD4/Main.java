package AISD4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(5);
        node.right = new Node<>(1);
        node.left = new Node<>(2);
        node.left.left = new Node<>(34);
        node.right.right = new Node<>(42);
        int i = 1;
        countPot(node, 1);
    }
    public static void countPot(Node node, int i){
        if (node != null ){
            i++;
            countPot(node.left, i);
            countPot(node.right, i);
        }
//        else if(node.left != null node.right == null){
//
//        }
        System.out.println(i);
    }
}
