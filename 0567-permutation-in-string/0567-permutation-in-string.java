class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
       int[] arr = new int[26];
        
        //increase the counter for each character in the string s1 i.e. substring
        //we do c -'a' because we need the order of the characters like arr[0] = a, arr[1] = b etc
        for(char c: s1.toCharArray()){
            arr[c - 'a']++;
        }
        
        //Now arr = [1, 1, 0, 0, 0, ..., 0]
        
        int i = 0, j = 0;
        int count = s1.length();
        while(j < s2.length()){
            
            //if any character in s2, has value more than one then decreament the value
            //at j = 3 ==> [1, 1, 0, 0, 0, ..., 0] => [1, 0, 0, 0, 0, ..., 0]
            //so count = 2-- = 1;
            
             //if any character in s2, has value more than one then decreament the value
            //at j = 4 ==> [1, 0, 0, 0, 0, ..., 0] => [0, 0, 0, 0, 0, ..., 0]
            //so count = 1-- = 0;
            
            if(arr[s2.charAt(j++) - 'a']-- > 0)
                count--;
            
            //now count = 0 so all the characters from String s1 is present in String s2 => so return true
            if(count == 0)
                return true;
            
            
            if(j - i == s1.length() && arr[s2.charAt(i++) - 'a']++ >= 0)
                count++;
        }
        return false;
    }    
}