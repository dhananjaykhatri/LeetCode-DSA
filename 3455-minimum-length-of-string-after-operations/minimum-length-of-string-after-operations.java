class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> d = new HashMap<>();

        for (char c : s.toCharArray()) {
            d.put(c, d.getOrDefault(c, 0) + 1);
        }

        int dele = 0;

        for (char c : d.keySet()) {
            int count = d.get(c);
            if (count % 2 == 0) {
                dele += count - 2;
            } else {
                dele += count - 1;
            }
        }

        return s.length() - dele;
    }
}