import java.util.Arrays;

public class AssignCookies_455 {
    //贪心 简单题 优先把大的饼干分给胃口大的小孩
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = Math.min(g.length, s.length);
        int count = 0;
        int gp = g.length - 1;
        int sp = s.length - 1;
        while(gp >=0 && sp >= 0){
            if(s[sp] >= g[gp]){
                count++;
                sp--;
                gp--;
            }else{
                gp--;
            }
        }
        return count;
    }
}
