class Solution {
    public String reverseWords(String s) {
         int length = s.length();
        List<int[]> wordPositions = new ArrayList<>();  // To store start and end indices of words
        
        int i = 0;
        // Iterate through the string to identify word boundaries
        while (i < length) {
            // Skip leading spaces
            while (i < length && s.charAt(i) == ' ') i++;
            if (i == length) break;
            
            int start = i;  // Start of the word
            
            // Move to the end of the word
            while (i < length && s.charAt(i) != ' ') i++;
            int end = i - 1;  // End of the word
            
            // Store the start and end indices of the word
            wordPositions.add(new int[] {start, end});
        }
        
        StringBuilder result = new StringBuilder();
        // Reverse the order of the words and build the result string
        for (int j = wordPositions.size() - 1; j >= 0; --j) {
            // Extract the word using substring
            String word = s.substring(wordPositions.get(j)[0], wordPositions.get(j)[1] + 1);
            result.append(word);
            // Add a space between words, except for the last word
            if (j != 0) result.append(" ");
        }
        
        return result.toString();
    }
}