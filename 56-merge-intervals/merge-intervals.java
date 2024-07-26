class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        Stack <int[]> st= new Stack <>();
        st.add(intervals[0]);
        for(int i=0;i<intervals.length;i++)
        {
            if(intervals[i][0]<=st.peek()[1])
            {
                st.peek()[1]= Math.max(st.peek()[1],intervals[i][1]);
            }
            else
            {
                st.add(intervals[i]);
            }
        }
        int ans[][]= new int[st.size()][2];
        int i= st.size()-1;
        while(!st.empty())
        {
            ans[i][0]=st.peek()[0];
            ans[i--][1]=st.peek()[1];
            st.pop();

        }
return(ans);
        
    }
}