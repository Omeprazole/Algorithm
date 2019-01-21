public class Lintcode242_ConvertBTTOListByDepth {
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            ListNode dummyNode = new ListNode(0);
            ListNode p = dummyNode;
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                p.next = new ListNode(cur.val);
                p = p.next;
                if(cur.left != null) {
                    q.offer(cur.left);
                }

                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(dummyNode.next);
        }
        return res;
    }
}
