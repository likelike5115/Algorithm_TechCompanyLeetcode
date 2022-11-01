import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 利用哈希表进行回溯的解法
 * @Author
 */
public class PermutationsII_S1_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        recursion(nums, res, current,map);
        return res;
    }
    public void recursion(int[] nums, List<List<Integer>> res, List<Integer> current, Map<Integer,Integer> map){
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){ //注意这里是遍历哈希表而不是nums数组
            int n = entry.getKey();
            if(map.get(n) > 0){
                map.put(n, map.get(n) - 1);
                current.add(n);
                recursion(nums, res, current,map);
                map.put(n, map.get(n) + 1);
                current.remove(current.size() - 1);
            }
        }


    }
}
