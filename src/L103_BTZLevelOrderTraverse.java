public class L103_BTZLevelOrderTraverse {
    //BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        boolean inOder = true;
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                //Expand the current node
                if(inOder) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }

                //Generote next nodes
                if(cur.left != null) {
                    q.offer(cur.left);
                }

                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(list);
            inOder = inOder ? false : true;
        }
        return res;
    }

    //DFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        if(level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }

        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}
