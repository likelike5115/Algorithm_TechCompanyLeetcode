import java.util.PriorityQueue;

/**
 * @Description Kruskal + 并查集解法
 * @Author
 */
public class MinCostToAllPoints_S2_1584 {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((v1, v2) -> v1[2] - v2[2]);
        int[] root = new int[points.length];
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                heap.add(new int[]{i, j, dist});
            }
        }      //先将图中所有的边推入小根堆
        for(int i = 0; i < points.length; i++){
            root[i] = i;
        }
        int res = 0;
        while(!heap.isEmpty()){   //依次poll小根堆得到当前边
            int[] edge = heap.poll();
            int from = edge[0];
            int to = edge[1];
            int value = edge[2];
            int rootFrom = find(from,root);
            int rootTo = find(to,root);
            if(rootFrom != rootTo){ //如果这条边的入点和出点不是同一个根节点，则说明不会形成环，可以加入结果
                root[rootFrom] = rootTo;
                res += value;   //加入结果后把入节点的根节点挂载到出节点的根节点上（union操作)
            }
        }


        return res;
    }
    public int find(int node, int[] root){
        if(root[node] == node){
            return node;
        }
        return root[node] = find(root[node],root);
    }
}
