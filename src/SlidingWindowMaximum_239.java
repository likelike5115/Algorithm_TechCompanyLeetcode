import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author
 */
public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        PriorityQueue<int[]> heap = new PriorityQueue<>(
                new Comparator<int[]>(){
                    public int compare(int[] o1, int[] o2){
                        return o2[0] - o1[0];
                    }
                }
        );
        for(int num = 0; num < k; num++){
            heap.add(new int[]{nums[num],num});
        }
        //System.out.println(heap.peek()[0]);
        int[] res = new int[nums.length - k + 1];
        int i = k-1;
        while(i < nums.length){
            heap.add(new int[]{nums[i],i});
            while( heap.peek()[1] <= i - k){
                heap.poll();               //关键在于要用一个大根堆存数组值和索引，并在求最大值前把大根堆中索引为滑窗前面的值都移除
            }
            res[i - k + 1] = heap.peek()[0];
            i++;
        }
        return res;
    }
}
