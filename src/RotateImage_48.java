/**
 * @Description Usually matrix problem needs to have four pointers (l,r,t,b)
 * @Author
 */
public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int l = 0; int r = matrix.length - 1;

        while(l<r){
            int i = 0;
            while(i <= r - l - 1){   //move the pointer to median element
                int top = l; int bottom = r;
                //store tip left
                int topLeft = matrix[top][l + i];
                //move bottom right element to top left
                matrix[top][l + i] = matrix[bottom - i][l];
                matrix[bottom - i][l] = matrix[bottom][r - i];
                matrix[bottom][r - i] = matrix[top + i][r];
                matrix[top + i][r] = topLeft;
                i++;
            }
            l++;
            r--;
        }
    }
}
