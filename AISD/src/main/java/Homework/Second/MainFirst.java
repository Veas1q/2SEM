package Homework.Second;

public class MainFirst {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.right = new Tree(4);
        tree.right.left = new Tree(5);
        tree.left.left = new Tree(6);
        tree.right.right = new Tree(7);
        heightTree(tree);
    }
    public static int heightTree (Tree tree){
        if (tree == null){
            return 0;
        }
        int left = heightTree(tree.left);
        int right = heightTree(tree.right);
        System.out.println(tree.value + " " + (Math.max(left, right) + 1));
        return Math.max(left, right) + 1;
    }
}

