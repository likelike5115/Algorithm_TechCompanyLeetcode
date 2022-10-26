/**
 * @Description 尝试用dp解
 * @Author
 */
//用一个dp数组存某个位置能否到达终点，能则值为1
public class JumpGameI_S1_55 {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int[] dp = new int[nums.length];
        for(int i = nums.length - 2; i >=0; i--){ //最后一个位置的值不重要，所以从倒数第二个位置开始
            if(nums[i] + i >=  nums.length - 1){ //先判断本位置能不能直接跳到终点
                dp[i] = 1;
                continue;
            }
            for(int j = 1; j <= nums[i]; j++){ //若不能则检查这个位置能跳到的每个位置能否到达终点
                if(dp[i + j] == 1){  //时间复杂度仍然是O(N^2),需要优化掉这个步骤
                    dp[i] = 1;
                }
            }
        }
        return dp[0] == 1? true : false;
    }
}
