import java.util.HashSet;

/**
 * LeetCode: 给定⼀个包含⼤写字⺟和⼩写字⺟的字符串，找到通过这些字⺟构造成的最⻓
 * 的回⽂串。在构造过程中，请注意区分⼤⼩写。⽐如 "Aa" 不能当做⼀个回⽂字符串。注
 * 意:假设字符串的⻓度不会超过 1010。
 *
 * 输⼊:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最⻓的回⽂串是"dccaccd", 它的⻓度是 7。
 *
 * 回文串有两种情况：
 * 字符为双数或者多了一个单字符
 *
 * 那么只要统计每个字符的出现次数就行
 */
public class 最长回文串 {
    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //用于存放字符，来检查重复
        HashSet<Character> hashSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            //判断当前集合是否存在当前字符
            if (!hashSet.contains(chars[i])) {
                //不存在，存入集合
                hashSet.add(chars[i]);
            } else {
                //存在，从集合中移除字符并计数加一
                hashSet.remove(chars[i]);
                count++;
            }
        }
        //如果hashSet中剩了元素，那么可以取一个放在回文串正中间。
        return hashSet.isEmpty() ? count * 2 : count * 2 + 1;
    }

    public static void main(String[] args) {
        int res = longestPalindrome("abb");
        System.out.println(res);
    }
}
