import java.util.PriorityQueue;

/**
 * @Description Prim算法 求最小生成树MST
 * @Author
 */
public class MinCostToAllPoints_S1_1584 {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((v1, v2) -> v1[2] - v2[2]); //根据edge的value生成小根堆
        boolean[] selected = new boolean[points.length];
        heap.add(new int[]{-1,0,0}); //先加入初始点（用于初始化，不存在）
        int res = 0;
        int count = 0;
        while(!heap.isEmpty()){
            int[] edge = heap.poll();
            if(!selected[edge[1]]){  //如果这个点没被选过
                selected[edge[1]] = true;     //选择它
                res += edge[2];
                count++;
            }
            if(count == points.length){ //由于是求最小生成树，所以每个点都选过就可以停了
                break;
            }
            for(int i = 0; i < points.length;i++){   //把它与其他未被选择的点相连的边加入小根堆
                if(!selected[i] && i != edge[1]){
                    int dist = Math.abs(points[i][0] - points[edge[1]][0]) + Math.abs(points[i][1] - points[edge[1]][1]);
                    heap.add(new int[]{edge[1], i, dist});
                }
            }

        }
        return res;
    }
}
