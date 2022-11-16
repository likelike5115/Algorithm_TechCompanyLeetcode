public class UniqueBinarySearchTree_S2_96 {
    //用一个数组来记录
    public int numTrees(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        return countBST(n, arr);
    }
    public int countBST(int n, int[] arr){
        if(n == 0 || n == 1){
            return 1;
        }
        if(arr[n] != 0){
            return arr[n];
        }
        int count = 0;
        for(int i = 1; i <= n; i++){
            int left = countBST(i - 1, arr);
            int right = countBST(n - i, arr);
            count += left * right;
        }
        arr[n] = count;
        return count;
    }
}
