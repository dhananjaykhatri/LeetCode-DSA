class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> heightNameMp = new HashMap<>();
        int size = names.length;
        for(int indx = 0; indx < size; indx++){
            heights[indx] *= -1;
            heightNameMp.put(heights[indx], names[indx]);
        }
        Arrays.sort(heights);
        String sortedNames[] = new String[size];
        for(int indx = 0; indx < size; indx++){
            sortedNames[indx] = heightNameMp.get(heights[indx]);
        }
        return sortedNames;
    }
}