/**
 * @Description 理解二分法 较难
 * @Author
 */
public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int l = 0; int r = nums.length - 1;
        while(l<=r){
            int mid = (r - l) / 2 + l;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[0]){     //mid在pivot的左边还是右边 已落在左边
                if(target >= nums[0] && target < nums[mid]){   //如果target<nums[0]则肯定属于pivot右边，区间向右移动
                    r = mid - 1;               //有两个决定移动方向的因素，一是在哪个递增区间，二是在区间中target在mid的哪边
                }else{
                    l = mid + 1;
                }
            }else{    //已落在右边
                if(target <= nums[nums.length - 1] && nums[mid] < target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
