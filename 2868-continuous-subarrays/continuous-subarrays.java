class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;
        int end = 0, start = 0;
        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        while(end < n){
            curMin = Math.min(nums[end], curMin);
            curMax = Math.max(nums[end], curMax);
            //Update the curMin and curMax to nums[end]
            if(curMax - curMin > 2){
                start = end;
                curMin = nums[start];
                curMax = nums[start];
                //While moving backwards check the condition for continuity
                //,and update start, curMax and curMin for all 
                //valid elements into the subarray.
                while(start - 1 >= 0 && Math.abs(nums[start - 1] - nums[end]) <= 2){
                    start--;
                    curMin = Math.min(nums[start], curMin);
                    curMax = Math.max(nums[start], curMax);
                }
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }
}