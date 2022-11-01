import java.util.PriorityQueue;

/**
 * @Description
 * @Author
 */
public class FindFirstAndLastElementPosition_S1_34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0; int r = nums.length - 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<>((v1, v2) -> v2 - v1);
        while(l <= r){
            int mid = (r - l)/2 + l;
            if(nums[mid] == target){
                heap.add(mid);
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while(l <= r){
            int mid = (r - l)/2 + l;
            if(nums[mid] == target){
                heap2.add(mid);
                l = mid + 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        if(!heap.isEmpty() && !heap2.isEmpty()){
            return new int[]{heap.peek(), heap2.peek()};
        }else{
            return new int[]{-1, -1};
        }
    }
}
