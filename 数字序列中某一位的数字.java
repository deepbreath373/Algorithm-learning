/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 */
public class 数字序列中某一位的数字 {
    public int findNthDigit(int n) {
        long start = 1;
        //位数
        int digit = 1;
        //数位的个数
        long count = 9;
        //循环算出当前数位对应是几位数
        while(n > count){
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * start * digit;
        }
        //每 digit 个数位算一个数字
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n-1) % digit) - '0';
    }
}
