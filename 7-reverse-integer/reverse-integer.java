class Solution {
    public int reverse(int x) {
        long rev=0;
        boolean neg=false;
        if(x<0){
            neg=true;
            x=x*(-1);
        }
        while(x>0){
            int rem=x%10;
            rev=rev*10+rem;
            if(rev>Integer.MAX_VALUE||rev<Integer.MIN_VALUE){
                return 0;
            }
            x=x/10;
        }
        return neg?(int)rev*(-1):(int)rev;
    }
}