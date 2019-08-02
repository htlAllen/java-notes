package al.lt;

import java.util.ArrayList;
import java.util.Stack;
public class Entry{
    public static void main(String[] args){
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        for(int i=0; i < 9; i++){
            list.add(new TreeNode(i));
        }
        TreeNode root = list.get(0);
        for(int i=0; i< 4; i++){
            list.get(i).setLeft(list.get(2*i + 1));
            list.get(i).setRight(list.get(2*i + 2));
        }
        System.out.println(TreeNode.maxDepth(root));

    }
}

// 对于树相关的算法首先应该想到的就是递归了
class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
    public void setLeft(TreeNode node){
        left = node;
    }
    public void setRight(TreeNode node){
        right = node;
    }

    public void getValue() {
        System.out.println(val);
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.left);
            root.getValue();
            preOrder(root.right);
        }
    }
    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1 + Math.max(left, right);
        }
    }
}
