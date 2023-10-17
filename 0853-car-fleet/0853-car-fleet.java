class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double cur = 0;
        int ans = 0;
        Map<Integer, Double> map = new TreeMap(Collections.reverseOrder());
        int n = position.length;
        
        for(int i = 0; i<n; i++){
            map.put(position[i], (double)(target - position[i]) / speed[i]);
        }
        
        for(double time: map.values()){
            if(time > cur){
                cur = time;
                ans++;
            }      
        }
        return ans;
    }
}