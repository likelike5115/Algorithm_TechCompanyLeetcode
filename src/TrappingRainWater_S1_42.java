/**
 * @Description
 * @Author
 */
public class TrappingRainWater_S1_42 {
    //Brute Force 暴力解
    //每个柱子积水量是 min(maxLeft, maxRight) - height[i]  所以需要求出每个柱子的左边最高柱子和右边最高柱子
    public int trap(int[] height) {
        if(height.length <= 1){
            return 0;
        }
        int ans = 0;
        for(int i = 1; i < height.length - 1; i++){
            int l = height[i];          //这里是从自己开始的，如果无水柱子左边和右边都比自身低，min(maxLeft, maxRight) - height[i]
            // 仍然是0不会影响答案
            int r = height[i];
            int ln = i; int rn = i;
            while(ln >= 1){
                ln = ln - 1;
                l = Math.max(l, height[ln]);  //是重复过程。可用动态规划优化
            }
            while(rn < height.length - 1){
                rn = rn + 1;
                r = Math.max(r, height[rn]);
            }
            if(l != 0 && r!= 0){
                ans += Math.min(r,l) - height[i];
            }

            //System.out.println(i + " " + l + " " + r + " " + ans);
        }
        return ans;
    }
}
