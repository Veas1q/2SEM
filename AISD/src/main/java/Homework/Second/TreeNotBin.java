package Homework.Second;

import java.util.ArrayList;
import java.util.List;

public class TreeNotBin {
    int value;
    List<TreeNotBin> treeNotBinList = new ArrayList<>();
    public TreeNotBin(int value) {
        this.value = value;
        this.treeNotBinList = new ArrayList<>();
    }

    public void addTree(TreeNotBin tree) {
        this.treeNotBinList.add(tree);
    }
}
