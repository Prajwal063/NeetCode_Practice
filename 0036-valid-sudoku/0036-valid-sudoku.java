class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                char cur = board[i][j];
                if(cur!='.'){
                    
                    //used strings while adding so that it's easy to know where the element is repeating
                    //if cannot add a value in a specific row OR column OR subbox -> return false
                    //else true
                    
                    if(!set.add(cur + "row "+i)|| !set.add(cur +"col "+j) || 
                    !set.add(cur + "box " +i/3+ "-"+j/3 )){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}