import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description Brute Force 基于Set的暴力解法
 * @Author
 */
public class N_Queens_S1_51 {
    List<String> board = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        String s = "";
        for(int i = 0; i < n; i++){    //构建一个全是"."的棋盘
            s += ".";
        }
        for(int j = 0; j < n; j++){
            board.add(s);
        }
        backTrack(0, n);
        return res;
    }
    public void backTrack(int r, int n){
        if(r == n){
            res.add(new ArrayList(board));   //注意这里要new 一个新的ArrayList 因为有加入/移出set的操作
            return;
        }
        for(int c = 0; c < n; c++){
            if(col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)){
                continue;       //重点在于 不同的皇后不能有相同列值，行+列值（若在同一条对角线上则有r+c或r-c相等）
            }
            col.add(c);
            posDiag.add(r + c);   //筛选出合法的位置加入set
            negDiag.add(r - c);
            StringBuffer s = new StringBuffer(board.get(r));
            s.replace(c, c+1, "Q");  //转换成StringBuffer使用replace再转换回来
            board.set(r, s.toString());

            backTrack(r + 1, n);

            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            StringBuffer s2 = new StringBuffer(board.get(r));   //从set中移除
            s2.replace(c, c+1, ".");
            board.set(r, s2.toString());
        }
    }
}
