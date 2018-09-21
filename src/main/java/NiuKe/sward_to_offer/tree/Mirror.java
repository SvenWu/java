package NiuKe.sward_to_offer.tree;


/**
 * Created by wth on 2017/5/6.
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
