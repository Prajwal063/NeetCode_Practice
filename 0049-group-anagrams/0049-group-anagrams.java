class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String res = new String(arr);

            if(!mp.containsKey(res)){
                mp.put(res, new LinkedList<String>());
            }
            mp.get(res).add(s);
        }
        return new LinkedList<>(mp.values());
    }
}