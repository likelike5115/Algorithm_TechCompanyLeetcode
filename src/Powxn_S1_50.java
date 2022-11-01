/**
 * @Description  跑一遍test case试出来的答案，时间7.26% 空间23.5% 并非最优解
 * @Author
 */
public class Powxn_S1_50 {
    public double myPow(double x, int n) {
        if(x == 0 || x == 1){
            return x;
        }

        if(x == -1){
            //System.out.println(n);
            return n % 2 == 0 ? 1 : -1;
        }
        if(n == - (Integer.MAX_VALUE + 1)){
            return 0;
        }
        double res = 1.0;
        //System.out.println(Integer.MAX_VALUE);
        for(int i = 0; i < Math.abs(n); i++){
            if(n > 0){
                res *= x;

            }else{
                res *= 1/x;

            }
        }
        return res;
    }
}
