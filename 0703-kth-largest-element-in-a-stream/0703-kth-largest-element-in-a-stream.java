class KthLargest {
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n: nums)
            add(n);
    }
    
    public int add(int val) {
        if(maxHeap.size() < k){
            maxHeap.offer(val);
        }
        else if(val > maxHeap.peek()){
            maxHeap.poll();
            maxHeap.offer(val);
        }
        return maxHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */