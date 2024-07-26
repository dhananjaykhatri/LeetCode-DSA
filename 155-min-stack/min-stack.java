class MinStack {
    static Stack<Integer> s;
    static Stack<Integer> s2;
    public MinStack() {
        s = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(s2.size()==0) s2.push(val);
        else{
            if(s2.peek()>=val) s2.push(val);
        }
    }
    
    public void pop() {
        int x=s.pop();
        if(s2.size()!=0 && s2.peek()==x) s2.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}