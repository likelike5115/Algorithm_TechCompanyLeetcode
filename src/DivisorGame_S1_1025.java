public class DivisorGame_S1_1025 {
    //博弈论简单题 实际上只需要考虑两轮，Alice那轮是贪心的原理，拿到不让Bob赢的数就赢了 可用动态规划优化
    public boolean divisorGame(int n) {
        return recursion(n);
    }
    public boolean recursion(int n){
        if(n == 1){
            return false;
        }else{
            for(int i = 1; i < n; i++){
                if(n % i == 0){
                    if(!recursion(n - i)){
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
