public class UniqueBinarySearchTrees_S1_96 {
    //递归解法 选当前节点当root会产生的BST为left*right
    public int numTrees(int n) {
        return countBST(n);
    }
    public int countBST(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int count = 0;
        for(int i = 1; i <= n; i++){
            int left = countBST(i - 1);
            int right = countBST(n - i);
            count += left * right;
        }
        return count;
    }
}
