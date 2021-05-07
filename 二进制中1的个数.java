/**
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 */
public class 二进制中1的个数 {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) != 0){
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int hammingWeight3(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(hammingWeight2(0b11111111111111111111111111111101));
    }
}
