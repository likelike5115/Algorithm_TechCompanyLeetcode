import java.util.ArrayList;
import java.util.List;
//hard题 参照leetcode 36和八皇后问题  判断在每行，每列，每块合不合规 使用回溯+剪枝
public class SudokuSolver_37 {
    boolean[][] row = new boolean[9][9]; //【第几行】【九个数】
    boolean[][] col = new boolean[9][9];//【第几列】【九个数】
    boolean[][][] block = new boolean[3][3][9];
    List<int[]> space = new ArrayList<>(); //用一个list 记录
    private boolean valid = false;
    public void solveSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int cur = board[i][j] - '1';
                    row[i][cur]=col[j][cur]=block[i/3][j/3][cur] = true;
                }else{
                    space.add(new int[]{i, j});
                }

            }
        }
        recursion(board, 0);

    }
    public void recursion(char[][] board, int pos){
        if(pos >= space.size()){
            valid = true;    //遇到了需要把这个答案保存下来
            return;
        }
        int i = space.get(pos)[0];
        int j = space.get(pos)[1];
        for(int k = 0; k < 9 && !valid; k++){
            //System.out.println(k);
            if(!row[i][k] && !col[j][k] && !block[i/3][j/3][k]){
                board[i][j] = (char)(k  + '1');
                row[i][k]=col[j][k]=block[i/3][j/3][k] = true;
                recursion(board, pos + 1);
                row[i][k]=col[j][k]=block[i/3][j/3][k] = false;
            }
        }
    }
}
