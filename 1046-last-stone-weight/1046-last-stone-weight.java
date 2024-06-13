class Solution {
    public int lastStoneWeight(int[] stones) {
        
//         //-i: Negating the stone values turns the min-heap behavior of the priority queue into a max-heap behavior.
//         //-pq.remove(): The final value is negated again to convert it back to the original value.
        
//         PriorityQueue<Integer> pq = new PriorityQueue();
//         for(int i: stones)  
//             pq.offer(-i);       //-i is added -> smallest element will become largest element when negated: max heap
        
//         while(pq.size() > 1){
//             int i1 = pq.remove();
//             int i2 = pq.remove();
//             if(i1 != i2)
//                 pq.add(i1 - i2);
//         }
        
//         return pq.size() != 0 ? (-pq.remove()) : 0;
        
        
        Arrays.sort(stones);
        for(int i = stones.length - 1; i > 0; i--){
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);
        }
        return stones[0];
    }
}