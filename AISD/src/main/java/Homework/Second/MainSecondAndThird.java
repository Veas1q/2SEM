package Homework.Second;

public class MainSecondAndThird {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.right = new Tree(5);
        tree.left.left = new Tree(4);
        tree.right.right = new Tree(6);
        System.out.println(treeToStr(tree));





        TreeNotBin root = new TreeNotBin(1);
        TreeNotBin node2 = new TreeNotBin(2);
        TreeNotBin node3 = new TreeNotBin(3);
        TreeNotBin node4 = new TreeNotBin(4);
        TreeNotBin node5 = new TreeNotBin(5);
        TreeNotBin node6 = new TreeNotBin(6);

        root.addTree(node2);  // 1 → 2
        root.addTree(node3);  // 1 → 3
        root.addTree(node4);  // 1 → 4
        node3.addTree(node5); // 3 → 5
        node3.addTree(node6); // 3 → 6

        System.out.println(treeToStrNotBin(root));
    }
    public static String treeToStr(Tree tree) {
        if (tree == null) {
            return "NULL";
        }

        String res = String.valueOf(tree.value);
        return "(" + res + ", " + treeToStr(tree.left) + ", "+ treeToStr(tree.right) + ")";
    }
    public static String treeToStrNotBin(TreeNotBin tree){
        if (tree == null){
            return "NULL";
        }
        if (tree.treeNotBinList.isEmpty()){
            return "(" + tree.value + ", NULL)";
        }
        String res = "";
        for(TreeNotBin s: tree.treeNotBinList){
            if(!res.isEmpty()){
                res += ",";
            }
            res += treeToStrNotBin(s);
        }
        return "(" + tree.value + "," + res + ")";
    }
}
