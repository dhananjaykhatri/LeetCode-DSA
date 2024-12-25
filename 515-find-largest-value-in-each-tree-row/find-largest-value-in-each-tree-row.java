/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<Integer>(); // Edge case: empty tree
        Deque<TreeNode> queue = new ArrayDeque<>(); // Queue for BFS
        queue.addLast(root);
        List<Integer> largest = new ArrayList<>(); // To store max values for each row

        while(!queue.isEmpty()) {
            int len = queue.size(); // Number of nodes at current level
            int max = Integer.MIN_VALUE; // Initialize max value for this level
            
            // Iterate through current level
            for(int i = 0;i < len;i++) {
                TreeNode currNode = queue.pollFirst();
                // Update max value if needed
                if(currNode.val > max) max = currNode.val;

                // Add children to the queue if they exist
                if(currNode.left != null) queue.addLast(currNode.left);
                if(currNode.right != null) queue.addLast(currNode.right);
            }

            // Add the max value to the result
            largest.add(max);
        }

        return largest;
    }
}