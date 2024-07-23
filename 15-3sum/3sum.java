class Solution {
    public List<List<Integer>> threeSum(int[] arr) {

        Arrays.sort(arr);
        ArrayList<Integer>list=new  ArrayList<>();
        List<List<Integer>>list2=new  ArrayList<>();
        HashSet<List<Integer>>mpp=new HashSet<>();
        int i=0;
        int j=1;int k=arr.length-1;
        while(i<j && j<k){   
           while(j<k){
            if(arr[i]+arr[j]+arr[k]==0)
            {
                 Collections.addAll(list,arr[i],arr[j],arr[k]);
                 mpp.add(list);
                 list=new  ArrayList<>();
                j++;k--;
            }
            else if(arr[i]+arr[j]+arr[k]>0)
            k--;
            else if(arr[i]+arr[j]+arr[k]<0)
            j++;
           }
           i++;
           j=i+1;k=arr.length-1;  
        }
        for(List<Integer> ii:mpp){
            list2.add(ii);
        }
        return list2;
    }
}