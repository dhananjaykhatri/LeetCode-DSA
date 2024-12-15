class FindSumPairs {
    int arr1[];
    int arr2[];
    HashMap<Integer,Integer> hp;

    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1 = nums1;
        arr2 = nums2;
        hp = new HashMap<>();

        for(int a : arr2){
            hp.put(a,hp.getOrDefault(a,0)+1);
        }
    }
    
    public void add(int index, int val) {
        hp.put(arr2[index],hp.getOrDefault(arr2[index],0)-1);
        arr2[index]+=val;
        hp.put(arr2[index],hp.getOrDefault(arr2[index],0)+1);
    }
    
    public int count(int tot) {
        int ans = 0;

        for(int a : arr1){
            if(hp.containsKey(tot-a)){
                ans+=hp.get(tot-a);
            }
        }
        return ans;
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