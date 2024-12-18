class Solution {
    public int[] finalPrices(int[] prices) {
        int[] arr = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i =prices.length-1;i>=0;i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek()>prices[i]){
                     stack.pop();
                }
            }
            arr[i] = stack.peek();
            stack.push(prices[i]);
            }

            for(int i=0;i<arr.length;i++){
                prices[i] = prices[i] - arr[i];
            }
            
            return prices;
        }
    }