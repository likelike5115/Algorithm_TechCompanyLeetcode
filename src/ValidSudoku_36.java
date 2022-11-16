public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9]; //【第几行】【九个数】
        int[][] col = new int[9][9];//【第几列】【九个数】
        int[][][] block = new int[3][3][9];
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != '.'){
                    int cur = board[i][j] - '1';
                    row[i][cur]++;
                    col[j][cur]++;
                    block[i/3][j/3][cur]++;
                    if(row[i][cur] > 1 || col[j][cur] > 1 || block[i/3][j/3][cur] > 1){
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
