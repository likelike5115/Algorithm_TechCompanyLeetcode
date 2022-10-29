import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description  这题难点在双指针和跳去重复的元素
 * @Author
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while(i < nums.length - 2){
            if(nums[i] > 0) return res;
            if(i > 0 && nums[i] == nums[i - 1]){ //这里是if不是while, 一定要用continue跳过此次循环，用while的话还会计算后面的值
                i++;           //后面有重复的i跳过，只计算第一个不重复的i
                continue;
            }
            int pre = i + 1;
            int post = nums.length - 1;
            while(pre < post){          //双指针 注意sum的计算要在这个循环内 因为sum值会随pre,post变化
                if(nums[i] + nums[pre] + nums[post] < 0){
                    pre++;                                 //这里可以用while跳过重复元素，也可以不跳，不知道为什么用while时间复杂度变高了
                }else if(nums[i] + nums[pre] + nums[post] > 0){
                    post--;

                }else{

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[pre]);
                    list.add(nums[post]);
                    res.add(list);
                    int numPre = nums[pre];
                    int numPost = nums[post];
                    pre++;
                    post--;
                    while(nums[pre] == numPre && pre < post){     //这里一定要跳过，避免加入重复的多个list到结果里
                        pre++;
                    }
                    while(nums[post] == numPost && pre < post){
                        post--;
                    }
                }
            }
            i++;

        }
        return res;
    }
}
