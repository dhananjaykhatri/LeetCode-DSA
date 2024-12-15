class FindSumPairs {
    int[] nums1,nums2;
    HashMap<Integer,Integer> hm=new HashMap<>();
    //intialize arrays and hashmap
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        //add nums2 ele to hashmap
        for(int i:nums2)
        hm.put(i,hm.getOrDefault(i,0)+1);
    }
    public void add(int index, int val) {
        //get the value of that index and add value+val to map and update hashmap and nums2[index]
        int v=nums2[index];
        if(hm.get(v)==1)
            hm.remove(v); 
        else
            hm.put(v,hm.get(v)-1);

        hm.put(v+val,hm.getOrDefault(v+val,0)+1);
        nums2[index]+=val;
    }
    
    public int count(int tot) {
        int cnt=0;
        for(int i:nums1)
        {
            //add dup pairs also
            if(hm.containsKey(tot-i))
            cnt+=hm.get(tot-i);
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */