class Solution {
    public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap();
//         for(int i: nums){
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }
        
//         PriorityQueue<Map.Entry<Integer, Integer>> pq = 
//             new PriorityQueue<>((a,b)->b.getValue().compareTo(a.getValue()));

//         for(Map.Entry e: map.entrySet()){
//             pq.add(e);
//         }
        
//         int[] ans = new int[k];
//         for(int i = 0; i<k; i++){
//             ans[i] = pq.poll().getKey();            
//         }
//         return ans;
        
        Map<Integer, Integer> map = new HashMap();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>
            ((a,b) -> b.getValue().compareTo(a.getValue()));
        for(Map.Entry e: map.entrySet()){
            pq.add(e);
        }
        
        int[] ans = new int[k];
        for(int i =0; i<k; i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}