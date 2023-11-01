class Solution {
    public String minWindow(String s, String t) {
        int n = t.length();
        int m = s.length();
        
        int i = 0, j = 0;
        int count = n;
        int minLen = Integer.MAX_VALUE; //window size
        int minStart = 0;   //left pointer
        
        int[] arr = new int[128];
        
        //increase the counter for each character in the string t i.e. substring
        //no need to to c - 'a' because we dont need the order in arr
        for(char c: t.toCharArray()){
            arr[c]++;
        }
        
        //if any character in s2, has value more than one then decreament the value
        //at some j ==> [1, 1, 1, 0, 0, ..., 0] => [1, 0, 0, 0, 0, ..., 0]
        //so count = 3-- = 2;
        while(j < m){
            if(arr[s.charAt(j++)]-- > 0){
                count--;
            }
            
            //if count becomes 0 it means we got the window
            //now we need to fing minimum window
            //if minimum window found, then set minLen(i.e. minWindow) to small window found and
            //change the minStart = ith posistion
            while(count == 0){
                if(minLen > j - i){
                    minLen = j - i;
                    minStart = i;
                }  
                
                //if character at start (i.e. i) is 0, then increment it
                //thus returning back the original arr formed at line 15 to 17 and "GET OUT OF WHILE LOOP"
                if(arr[s.charAt(i++)]++ == 0){
                    count++;
                }
            } 
        }
        //ternary op. => if not found return "",  else
        //return substring that minStart i.e START of minimum window found
        //TILL minStart + minimum window (minLen) found i.e. END of substring
        return minLen == Integer.MAX_VALUE? "": s.substring(minStart, minStart + minLen);   //s.substring(start, end) in easy words
    }
}