public class L272_ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> prevStack = new LinkedList<>();
        Deque<TreeNode> succStack = new LinkedList<>();
        buildStack(root, target, true, prevStack);
        buildStack(root, target, false, succStack);

        //Incase the peak has the same value, remove the prev one.
        if(!prevStack.isEmpty() && !succStack.isEmpty() && prevStack.peekFirst().val == succStack.peekFirst().val) {
            getNext(prevStack, true);
        }

        while(k > 0) {
            if(prevStack.isEmpty()) {
                res.add(getNext(succStack, false).val);
            } else if(succStack.isEmpty()) {
                res.add(getNext(prevStack, true).val);
            } else {
                if(target - prevStack.peekFirst().val <= succStack.peekFirst().val - target) {
                    res.add(getNext(prevStack, true).val);
                } else {
                    res.add(getNext(succStack, false).val);
                }
            }

            k--;
        }
        return res;
    }

    private void buildStack(TreeNode root, double target, boolean isPrev, Deque<TreeNode> stack) {
        while(root != null) {
            if(root.val > target) {
                if(!isPrev) {
                    stack.offerFirst(root);
                }
                root = root.left;

            } else if(root.val < target){
                if(isPrev) {
                    stack.offerFirst(root);
                }
                root = root.right;
            } else {
                stack.offerFirst(root);
                return;
            }
        }
    }

    private TreeNode getNext(Deque<TreeNode> stack, boolean isPrev) {
        TreeNode res = stack.pollFirst();
        TreeNode cur = isPrev ? res.left : res.right;
        while(cur != null) {
            stack.offerFirst(cur);
            cur = isPrev ? cur.right : cur.left;
        }

        return res;
    }
}
