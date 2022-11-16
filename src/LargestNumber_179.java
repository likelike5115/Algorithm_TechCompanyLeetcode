import java.util.Arrays;

public class LargestNumber_179 {
    //重写排序方式 b + a这个数如果按ASCII码更大则排在前面
    //相似题目是剑指Offer45
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (a, b) -> {
            return (b+a).compareTo(a+b);
        });
        int i = 0;
        if(s[0].equals("0")){
            return "0";
        }
        String res = "";
        while(i < nums.length){
            res += s[i];
            i++;
        }
        return res;

    }
}
