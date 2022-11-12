public class ReshapeTheMatrix_566 {
    //简单题   重点在用一个index遍历二维数组， index/column number是行数 index % column number是列数
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(r*c != m*n){
            return mat;
        }
        int[][] res = new int[r][c];
        //int index = 0;
        int row=0;
        int column = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(column >= n){
                    column -= n;
                    row++;
                }
                res[i][j] = mat[row][column];
                column++;
                //index++;
            }
        }
        //答案为：
//        for (int x = 0; x < m * n; ++x) {
//            ans[x / c][x % c] = nums[x / n][x % n];
//        }

        return res;
    }
}
