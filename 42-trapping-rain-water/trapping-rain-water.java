class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = 0;

        // Calculate maximum heights to the left
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }

        // Calculate maximum heights to the right
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }

        // Calculate trapped water
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}