class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        backtrack_method(list, n, 0, 0, "");
        return list;
    }
    
    public void backtrack_method(List<String> list, int max, int open, int close, String cur){
        if(cur.length() == max * 2){
            list.add(cur);
            return;
        }
        if(open<max){
            backtrack_method(list, max, open+1, close, cur + "(");
        }
        if(close<open){
            backtrack_method(list, max, open, close+1, cur + ")");
        }
    }
}