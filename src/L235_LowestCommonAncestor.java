public class L235_LowestCommonAncestor {
    //DFS
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }

    }

    //Iteration
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        TreeNode cur = root;

        while(cur != null) {
            if(cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else if(cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return cur;
    }

}
