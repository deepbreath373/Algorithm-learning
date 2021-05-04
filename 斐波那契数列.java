/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 */
public class 斐波那契数列 {
    public static int fib(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n==2){
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }
    public static int fib2(int n) {
        int[] res = {0,1};
        if(n<2){
            return res[n];
        }
        int mod = 1000000007;
        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibN = fibN % mod;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN%mod;
    }
    public static int numWays(int n) {
        if(n<2){
            return 1;
        }
        int mod = 1000000007;
        int fibNMinusOne = 1;
        int fibNMinusTwo = 1;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibN = fibN % mod;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN%mod;
    }
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
