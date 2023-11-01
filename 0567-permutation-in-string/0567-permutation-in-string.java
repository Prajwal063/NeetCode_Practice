class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
       int[] arr = new int[26];
        
        for(char c: s1.toCharArray()){
            arr[c - 'a']++;
        }
        
        int i = 0, j = 0;
        int count = s1.length();
        while(j < s2.length()){
            
            //if any character in s2, has value more than one then decreament the value
            //[1, 1, 0, 0, 0, ..., 0] => [1, 0, 0, 0, 0, ..., 0]
            if(arr[s2.charAt(j++) - 'a']-- > 0)
                count--;
            if(count == 0)
                return true;
            if(j - i == s1.length() && arr[s2.charAt(i++) - 'a']++ >= 0)
                count++;
            
            
        }
        return false;
    }    
}