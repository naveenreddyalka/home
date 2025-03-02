/*
package ok.demo.tree;

import java.util.ArrayList;

import ok.demo.linkedlist.ll;

public class levellinkedlist {

    public static void main(String[] args) {
        // -------7-------
        // ----3------11---
        // --1---5----9---13
        // -n-2-4-6-8-10-12-14
        int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        node root = buildminbst.getbstNice(test, 0, test.length - 1);

        ArrayList<ll> levelList = new ArrayList<ll>();
        buildList(root, levelList, 0);
        System.out.println(levelList);
    }

    public static void buildList(node root, ArrayList<ll> levelList, int level) {
        if (root == null)
            return;
        if (levelList.size() == level) {
            ll treenode = new ll();
            treenode.setValue(root.getValue());
            levelList.add(treenode);
        } else {
            ll temp = levelList.get(level).getNext();
            ll treenode = new ll();
            treenode.setValue(root.getValue());
            levelList.get(level).setNext(treenode);
            treenode.setNext(temp);
        }

        buildList(root.getLeft(), levelList, level + 1);
        buildList(root.getRight(), levelList, level + 1);

    }
}
*/
