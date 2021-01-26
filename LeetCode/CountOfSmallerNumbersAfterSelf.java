/**
https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */

class Solution {
    class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;
        int count = 1;
        public TreeNode (int val) {
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        result.add(0);
        int[] arr = new int[1];
        for (int i = nums.length - 2; i >= 0; i--) {
            //result.add(insertNode(root, nums[i]));
            arr[0] = 0;
            recursiveInsert(root, nums[i], arr);
            result.add(arr[0]);
        }
        Collections.reverse(result);
        return result;
    }
    
    private int insertNode(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        int count = 0;
        while (true) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = node;
                    break;
                } else {
                    root = root.left;
                }
            } else {
                count += root.count;
                if (root.right == null) {
                    root.right = node;
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return count;
    }
    
    private TreeNode recursiveInsert(TreeNode root, int val, int[] arr) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val <= root.val) {
            root.count++;
            root.left = recursiveInsert(root.left, val, arr);
        } else {
            arr[0] += root.count;
            root.right = recursiveInsert(root.right, val, arr);
        }
        return root;
    }
}