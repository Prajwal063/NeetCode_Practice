class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int hottest = Integer.MIN_VALUE;
        
        for(int i = n-1; i >= 0; i--){
            if(temperatures[i] >= hottest){
                hottest = temperatures[i];
            }
            else{
                int j = i + 1;
                while(j < n && temperatures[j] <= temperatures[i]){
                    j++;
                }
                ans[i] = (j < n) ? j - i : 0;
            }
        }
        return ans;
    }
}