public class IncreasingTripletSubsequence_334 {
    //medium贪心题 原来以为必须是连续的三个数要用双指针 结果不是
    //重点在于让first和second数尽量小
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
            return false;
        }

        int first = nums[0]; int second = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > second){
                return true;
            }else if(nums[i] > first){
                second = nums[i];
            }else{
                first = nums[i];
            }
        }
        return false;

    }
}
