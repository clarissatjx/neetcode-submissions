class MinStack {
    class Node {
        int val;
        Node aft;

        public Node(int val) {
            this.val = val;
            this.aft = null;
        }
    }

    Node start; // alternates element-min-element-min...
    
    public MinStack() {
        this.start = null;
    }
    
    public void push(int val) {
        if (this.start == null) {
            Node min = new Node(val);
            Node elem = new Node(val);
            elem.aft = min;
            this.start = elem;
        } else {
            Node elem = new Node(val);
            int minSoFar = this.start.aft.val;
            Node min = new Node(Math.min(val, minSoFar));
            elem.aft = min;
            min.aft = this.start;
            this.start = elem;
        }
    }
    
    public void pop() {
        this.start = this.start.aft.aft;
    }
    
    public int top() {
        return this.start.val;
    }
    
    public int getMin() {
        return this.start.aft.val;
    }
}
