import java.util.HashSet;
import java.util.Set;

/**
 * @Description 只需要求解的个数，比N皇后I更简单
 * @Author
 */
public class N_QueenII_52 {
    int res = 0;
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    public int totalNQueens(int n) {
        backTrack(0, n);
        return res;
    }
    public void backTrack(int r, int n){
        if(r == n){
            res++;
            return;
        }
        for(int c = 0; c < n; c++){
            if(col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)){
                continue;
            }
            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);

            backTrack(r + 1, n);

            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);

        }
    }

}
