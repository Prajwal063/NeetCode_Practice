class Solution {
    public String minWindow(String s, String t) {
        int n = t.length();
        int m = s.length();
        
        int i = 0, j = 0;
        int count = n;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        int[] arr = new int[128];
        for(char c: t.toCharArray()){
            arr[c]++;
        }
        
        while(j < m){
            if(arr[s.charAt(j++)]-- > 0){
                count--;
            }
            while(count == 0){
                if(minLen > j - i){
                    minLen = j - i;
                    minStart = i;
                }  
                if(arr[s.charAt(i++)]++ == 0){
                    count++;
                }
            } 
        }
        return minLen == Integer.MAX_VALUE? "": s.substring(minStart, minStart + minLen);
    }
}