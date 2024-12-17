class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Create an array to store frequency of each character (a to z)
        int[] freq = new int[26];

        // Count the frequency of each character in the input string 's'
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // 'right' points to the highest character in the alphabet (z -> a)
        int right = 25;

        // Use a StringBuilder to build the result string efficiently
        StringBuilder sb = new StringBuilder();

        // Keep looping until no more characters are left to add to the result
        while (true) {
            // Skip over any characters with zero frequency from 'right' (starting from 'z')
            while (right >= 0 && freq[right] == 0) {
                right--;
            }

            // If all characters are exhausted, break out of the loop
            if (right < 0) break;

            // Add the current character to the result, but ensure it doesn't exceed repeatLimit
            int count = Math.min(freq[right], repeatLimit);
            for (int i = 0; i < count; i++) {
                sb.append((char) ('a' + right));
            }

            // Decrease the frequency of the character after using it
            freq[right] -= count;

            // If the current character still has occurrences left, attempt to add a different character
            if (freq[right] > 0) {
                int left = right - 1;
                // Find the next character (left) with a non-zero frequency
                while (left >= 0 && freq[left] == 0) {
                    left--;
                }

                // If no valid character left to add, break the loop
                if (left < 0) break;

                // Add the character to the result and decrease its frequency
                sb.append((char) ('a' + left));
                freq[left]--;
            }
        }

        // Convert the StringBuilder to a string and return it as the final result
        return sb.toString();
    }
}