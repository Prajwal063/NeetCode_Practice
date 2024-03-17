class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String ans = new String(arr);
            
            if(!map.containsKey(ans)){
                map.put(ans, new LinkedList<>());
            }
            map.get(ans).add(s);
        }
        return new LinkedList(map.values());
    }
}