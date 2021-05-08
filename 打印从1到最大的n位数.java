/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 */
public class 打印从1到最大的n位数 {
    //不考虑大数的情况下，可以暴力求解
    public int[] printNum(int n) {
        int number = (int) Math.pow(10, n);
        int[] arr = new int[number - 1];
        for (int i = 1; i < number; i++) {
            arr[i - 1] = i;
        }
        return arr;
    }

    //考虑大数的情况，使用字符串存数字
    char[] num;
    int[] ans;
    int count = 0, n;

    public int[] printNumbers(int n) {
        this.n = n;
        num = new char[n];
        ans = new int[(int) (Math.pow(10, n) - 1)];
        dfs(0);
        return ans;
    }

    private void dfs(int n) {
        if (n == this.n) {
            String tmp = String.valueOf(num);
            int curNum = Integer.parseInt(tmp);
            if (curNum != 0) {
                ans[count++] = curNum;
            }
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[n] = i;
            dfs(n + 1);
        }
    }
}
