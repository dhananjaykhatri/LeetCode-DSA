class Solution {
    public List<String> summaryRanges(int[] nums1) {

        var answer = new ArrayList<String>();

        int[] nums = new int[nums1.length + 1];

        for (int k = 0; k < nums1.length; k++) {
            nums[k] = nums1[k];
        }

        nums[nums.length - 1] = (int) Math.random() * 1000;

        int i = 1;
        int k = 0;

        int length = nums.length - 1;

        if (nums1.length == 1) {
            String zaeba = "" + nums[0];
            answer.add(zaeba);
            return answer;
        }

        while (i < nums.length) {

            int startIndex = i;

            if (nums[startIndex] - nums[k] == i - k) {
                i++;
            } else {

                if (k == i - 1) {
                    String zaeba = "" + nums[k];
                    answer.add(zaeba);
                    k++;
                    i = k + 1;
                } else if (nums[i] == nums[k + 1]) {
                    String zaeba = "" + nums[i];
                    answer.add(zaeba);
                } else {

                    String toPush = nums[k] + "->" + nums[i - 1];

                    answer.add(toPush);
                    k = i;
                    i++;
                }
            }

        }

        return answer;
    }
}