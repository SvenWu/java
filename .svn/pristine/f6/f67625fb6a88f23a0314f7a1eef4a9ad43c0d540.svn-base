package leetcode.Tree;

import java.util.Arrays;

/**
 * Created by wth on 2017/4/19.
 */
public class Main {
    /**
     * 106. Construct Binary Tree from Inorder and Postorder Traversal
     * */
     class TreeNode {
            int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        TreeNode node = new TreeNode(postorder[postorder.length-1]);
        for(int i = 0; i < postorder.length; i++){
            if(inorder[i] == postorder[postorder.length-1]){
                node.left = buildTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
                node.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length),Arrays.copyOfRange(postorder,i,postorder.length-1));
            }
        }
        return node;
    }

}
