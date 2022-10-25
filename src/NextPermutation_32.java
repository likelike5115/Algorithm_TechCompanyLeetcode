import java.util.Arrays;

/**
 * @Description 一个数组中所有数字按照大小顺序排列得到一个集合，给定一个排列 找到下一个排列（题目难懂）
 * @Author
 */
public class NextPermutation_32 {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int lastIndex = 0;                                 //找从左到右最后一个升序数组段落的峰值
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                lastIndex = i;
            }
        }

        if(lastIndex == 0){       //如果找不到说明整个数组为降序， 通过交换把整个数组变为升序
            for(int i = 0; i < nums.length/2; i++){
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
            return;
        }
        int index = lastIndex;
        for(int i = lastIndex; i < nums.length; i++){          //找到峰值lastIndex, 峰值向左交换能使组成的数变大，但峰值右边是递增的有可能
            if(nums[i] > nums[lastIndex - 1]){     //会有比nums[lastIndex - 1]更大的数， 找到这个数和lastIndex - 1位置上的数交换
                index = i;
            }
        }

        int temp = nums[lastIndex - 1];
        nums[lastIndex - 1] = nums[index];
        nums[index] = temp;
        //System.out.println(nums[index]);
        Arrays.sort(nums, lastIndex, nums.length); //然后将lastIndex 到nums.length-1的数变为升序就能得到下一个更大的数了
        return;

    }
}
