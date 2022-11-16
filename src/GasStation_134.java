public class GasStation_134 {
    //贪心medium题
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int maxIndex = 0;
        // int max = -1;
        // for(int i = 0; i < gas.length; i++){
        //     int num = gas[i] - cost[i];              //一开始我是想选择gas[i]最大或gas[i] - cost[i]最大的点出发，但是不合理
        //     if(num > max){
        //         max = num;
        //         maxIndex = i;
        //         System.out.println(maxIndex);
        //     }
        // }
        // if(max < 0){
        //     return -1;
        // }
        // int res = maxIndex;

        //0------x---(x+1)------endIndex
        //这题的关键在于，从0出发到达x发现sum<0了， 那么从0到x之间的任何点出发都不可能到x+1了 因为从前面获得的累计油量只会对油量数有所增加
        //知道了这个之后，一旦sum在x点小于0就把起始点设置为x+1
        //贪心只考虑当前状态下的最优选择（即0-x间油量消耗和不可以小于0)
        int remain = 0;
        int sum = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            sum = sum + gas[i] - cost[i];
            remain = remain + gas[i] - cost[i];
            if(remain < 0){
                remain = 0;
                start = i + 1;
            }
        }
        if(sum < 0){
            return -1;
        }
        return start;
    }
}
