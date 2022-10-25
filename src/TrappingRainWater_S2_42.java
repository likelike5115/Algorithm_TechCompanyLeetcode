/**
 * @Description
 * @Author
 */
public class TrappingRainWater_S2_42 {
    public int trap(int[] height) {
        if(height.length <= 1){
            return 0;
        }
        int ans = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        // for(int i = 1; i < height.length; i++){
        //     leftMax[i] = Math.max(leftMax[i-1], height[i]);      //优化 移至下面的循环内
        // }
        for(int i = height.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for(int i = 1; i < height.length - 1; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
            if(leftMax[i] != 0 && rightMax[i] != 0){
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return ans;
    }
}
