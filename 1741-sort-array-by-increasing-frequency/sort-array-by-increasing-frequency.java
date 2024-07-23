class Solution {
    public int[] frequencySort(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        // map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // // max heap
        // PriorityQueue<Integer> pq = new PriorityQueue<>(
        // (a, b) -> map.get(b) - map.get(a));
        // for (int key : map.keySet()) {
        // pq.offer(key);
        // }

        // int[] res = new int[nums.length];
        // int idx = nums.length - 1;
        // while (!pq.isEmpty()) {
        // int peek = pq.remove();
        // for (int i = 0; i < map.get(peek); i++) {
        // res[idx--] = peek;
        // }
        // }
        // return res;

        Map<Integer, Integer> map = new HashMap<>();
        // count frequency of each number
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
        // custom sort
        return Arrays.stream(nums).boxed()
                .sorted((a, b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
                .mapToInt(n -> n)
                .toArray();
    }
}