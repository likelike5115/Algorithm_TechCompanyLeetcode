/**
 * @Description
 * @Author
 */
public class FindTriangularSumOfAnArray_2221 {
    public int triangularSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length - 1;
        for(int i = 0; i < n;i++){
            int[] newArr = new int[nums.length - 1];
            //System.out.println(nums.length - 1);
            for(int j = 0; j < nums.length - 1; j++){
                newArr[j] = (nums[j] + nums[j+1]) % 10;
                //System.out.println(newArr[j]);
            }
            nums = newArr;
        }
        return nums[0];
    }
}
