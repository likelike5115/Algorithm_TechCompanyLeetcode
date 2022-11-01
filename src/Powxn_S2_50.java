/**
 * @Description 用递归方式解， 时间复杂度为O(log(n))
 * @Author
 */
public class Powxn_S2_50 {
    public double myPow(double x, int n) {
        if(x == 0 || x == 1){
            return x;
        }
        //long num  = (long)n;
        return n > 0 ? pow(x,Math.abs(n)) : 1/pow(x,Math.abs(n)); //计算全用n的正值，若n为负则最后取1/res
    }
    public double pow(double x, int n){
        if(n == 1){
            return x;
        }else if(n == 0){
            return 1;
        }
        double res = pow(x, n/2);
        return n % 2 == 0 ? res*res:res*res*x;  //n为奇数多乘一次x
    }
}
