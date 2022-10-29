/**
 * @Description 这是一道基于快速排序的题  快排： https://github.com/likelike5115/Sort/blob/main/src/QuickSort.java
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
                swap(nums, r--, i);
            }else{
                i++;
            }
            for(int n : nums){
                System.out.print(n);
            }
            System.out.println("");
        }
    }
    public void swap(int[] num, int l, int r){
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}
