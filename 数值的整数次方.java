/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 注意：考虑 x为0，为负数，n为0，为负数的特殊情况
 */
public class 数值的整数次方 {
    public static double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public static double myPow2(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        double result = myPow2(x, n >> 1);
        result *= result;
        if ((n & 0x1) == 1) {
            result *= x;
        }
        return result;
    }

    public static double myPow3(double x, int n) {
        if (x == 0 && n < 0) {
            return 0.0;
        }
        if (n < 0) {
            n = n * -1;
            double result = myPow2(x, n);
            result = 1.0 / result;
            return result;
        }
        return myPow2(x, n);
    }

    public static double myPow4(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = b * -1;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            res *= res;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow3(0.0, 10));
    }
}
