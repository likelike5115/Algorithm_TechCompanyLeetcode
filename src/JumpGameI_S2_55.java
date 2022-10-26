/**
 * @Description
 * @Author
 */
public class JumpGameI_S2_55 {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int[] dp = new int[nums.length];
        int index = nums.length - 1;
        for(int i = nums.length - 2; i >=0; i--){
            if(nums[i] + i >=  index){  //这里使用更机智的截断操作， 能到达最近的可以跳到终点的点即为正确（因为是比较一个范围的右边界即可）
                dp[i] = 1;
                index = i;
            }
        }
        return dp[0] == 1? true : false;
    }
}
