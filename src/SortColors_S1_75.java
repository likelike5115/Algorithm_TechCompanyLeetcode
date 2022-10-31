/**
 * @Description 经典荷兰国旗问题 这是一道基于快速排序的题  快排： https://github.com/likelike5115/Sort/blob/main/src/QuickSort.java
 * 还有一个解： 遍历一次数组统计0，1，2出现次数，然后再遍历一次数组赋值
 * @Author
 */
public class SortColors_S1_75 {
    public void sortColors(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int l = 0;
        int r = nums.length - 1;
        int i = l;
        while(i <= r){
            if(nums[i] == 0){
                swap(nums, l++, i++);
            }else if(nums[i] == 2){
                swap(nums, r--, i); //关键在于这里i 不能 ++
            }else{
                i++;
            }
        }
    }
    public void swap(int[] num, int l, int r){   //还可以优化到不用swap只用指针
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}
