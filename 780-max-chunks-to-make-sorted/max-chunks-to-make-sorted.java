class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count=0;

        int i=0,j=0;

        while(j<arr.length){
            
            for(int k=i;k<=j;k++){
                if(arr[k]<i||arr[k]>j){
                    while(true){
                        if(arr[k]>=i&&arr[k]<=j)break;
                        j++;
                    }
                }
            }
            count++;
            i=j+1;
            j=i;
        }

        return count;
    }
}