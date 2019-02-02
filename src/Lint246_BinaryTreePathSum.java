public class Lint246_BinaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        dfs(root, target, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        int curSum = 0;
        for(int i = list.size() - 1; i >= 0; i--) {
            curSum += list.get(i);
            if(curSum == target) {
                List<Integer> newList = new ArrayList<>();
                for(int j = i; j < list.size(); j++) {
                    newList.add(list.get(j));
                }
                res.add(newList);
            }
        }

        if(root.left != null) {
            dfs(root.left, target, res, list);
            list.remove(list.size() - 1);
        }

        if(root.right != null) {
            dfs(root.right, target, res, list);
            list.remove(list.size() - 1);
        }

    }
}
