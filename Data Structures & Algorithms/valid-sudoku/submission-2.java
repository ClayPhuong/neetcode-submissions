class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check dup in row
        for(int row = 0; row < 9; row++){
            Set<Character> set = new HashSet<>();
            for (int i=0; i<9; i++) {
                if(board[i][row] == '.') continue;
                if(set.contains(board[i][row])) return false;
                set.add(board[i][row]);
            }
        }

        // check dup in col
        for (int col = 0; col < 9; col++ ){
            Set<Character> set = new HashSet<>();
            for (int i=0; i<9; i++) {
                if(board[col][i] == '.') continue;
                if(set.contains(board[col][i])) return false;
                set.add(board[col][i]);
            }
        }

        // check dup in box 3x3
        for(int row=0; row<9;row+=3) {
            for (int col=0; col<9; col+=3) {
                Set<Character> set = new HashSet<>();
                for(int i=row; i<row+3;i++){
                    for (int j=col; j<col+3; j++){
                        if(board[i][j] == '.') continue;
                        if (set.contains(board[i][j])) return false;
                        set.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
