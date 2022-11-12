public class NimGame_292 {
    //11/11 第一次做博弈论题目 这题可以先从数字3开始寻找规律 我方拿到1-3的数必赢， 4会输， 5可以1+(1-3)+(1-3)赢，
    //6可以2 + (1-3) + (1-3) 赢
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
