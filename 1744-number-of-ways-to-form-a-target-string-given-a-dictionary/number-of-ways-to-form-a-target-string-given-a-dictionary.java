class Solution {
    private final long MOD = 1000_000_000+7;
    private int getIndexOfChar(List<long[]> list, int ch){
        int it = 0;
        for(long[] l: list){
            if(l[0]==ch) return it;
            it++;
        }
        return -1;
    }
    private long process(List<List<long[]>> wordsMap, String target, int i , int j, int skips, long[][] dp){
        if(j==target.length()){
            // if will reach the target end their is one possible way
            return 1;
        }
        if(i==wordsMap.size())return 0;
        if(dp[i][j] != -1)return dp[i][j];
        long skippedRes = 0;
        // if target length < wordi length ,can skip current
        if(skips>0) skippedRes = process(wordsMap,target, i+1, j, skips-1,dp) %MOD;
        long notSkippedRes = 0;
        for(long[] e : wordsMap.get(i)){
            // for each character in level if match with target current character increment i and j ,
            // if there are more the one count of char at ith level then multiple by that
            if(target.charAt(j)==e[0]) {
                notSkippedRes += (e[1] *  process(wordsMap,target,i+1,j+1,skips,dp));
                notSkippedRes = notSkippedRes % MOD;
            };
        }
        return dp[i][j]=(skippedRes + notSkippedRes) % MOD;
    }
    public int numWays(String[] words, String target) {

        //word map will contain level wise characters and their counts
        /*
            Example For; ["acca","bbbb","caca"]
            level map will be 
                0 : a 1 b 1 c 1
                1 : c 1 b 1 a 1
                2 : c 2 b 1
                3 : a 2 b 1

         */ 
        List<List<long[]>> wordsMap = new ArrayList<>();
        if(target.length()>words[0].length())return 0;
        for(int i=0;i<words[0].length();i++) wordsMap.add(new ArrayList<>());
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[0].length();j++){
                // find if character already exists in list
                int ind = getIndexOfChar(wordsMap.get(j),words[i].charAt(j));
                if(ind == -1){
                    wordsMap.get(j).add(new long[]{words[i].charAt(j),1});
                }else{
                    wordsMap.get(j).get(ind)[1]+=1;
                }
            }
        }
        long[][] dp = new long[words[0].length()][target.length()];
        for(long[] d: dp)Arrays.fill(d,-1);
        int res = (int)process(wordsMap,target,0,0,words[0].length()-target.length(),dp);
        return res;
    }
}