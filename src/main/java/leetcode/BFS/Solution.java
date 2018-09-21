package leetcode.BFS;

import java.util.Arrays;

/**
 * Created by wth on 2017/4/18.
 */
 class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

public class Solution {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postorder.length-1]);
        for(int i = 0; i < postorder.length; i++){
            if(postorder[i] == inorder[inorder.length-1]){
                node.left = buildTree(Arrays.copyOfRange(inorder, 0, i),Arrays.copyOfRange(postorder,0,i));
                node.right = buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length),Arrays.copyOfRange(postorder,i,postorder.length-1));
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{1,3,2};
        int[] postorder = new int[]{3,2,1};
        TreeNode root = buildTree(inorder,postorder);
        System.out.println(root.left.val);
    }
}


