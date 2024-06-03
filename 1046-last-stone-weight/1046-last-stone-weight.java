class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i: stones)  
            pq.offer(-i);
        while(pq.size() > 1){
            int i1 = pq.remove();
            int i2 = pq.remove();
            if(i1 != i2)
                pq.add(i1 - i2);
        }
        return pq.size() != 0 ? (-pq.remove()) : 0;
        
        
        // Arrays.sort(stones);
        // for(int i = stones.length - 1; i > 0; i--){
        //     stones[i - 1] = stones[i] - stones[i - 1];
        //     Arrays.sort(stones);
        // }
        // return stones[0];
    }
}