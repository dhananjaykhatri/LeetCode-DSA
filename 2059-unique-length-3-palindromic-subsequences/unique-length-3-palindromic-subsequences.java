class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Set<String> uniquePalindromes = new HashSet<>();
        
        Set<Character> prefixSet = new HashSet<>();
        int[] suffixCount = new int[26]; 

        for (char c : s.toCharArray()) {
            suffixCount[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            char middle = s.charAt(i);

            suffixCount[middle - 'a']--;

            for (char c = 'a'; c <= 'z'; c++) {
                if (prefixSet.contains(c) && suffixCount[c - 'a'] > 0) {
                    uniquePalindromes.add("" + c + middle + c);
                }
            }

            prefixSet.add(middle);
        }

        return uniquePalindromes.size();
    }
}