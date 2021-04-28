/**
 * LeetCode: 给定⼀个字符串，验证它是否是回⽂串，只考虑字⺟和数字字符，可以忽略字⺟
 * 的⼤⼩写。 说明：本题中，我们将空字符串定义为有效的回⽂串。
 * <p>
 * 输⼊: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 输⼊: "race a car"
 * 输出: false
 * <p>
 * 从字符串两端向内遍历，判断左右两边的字符是否相等。
 */
public class 验证回文串 {
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        //设置边界
        int l = 0, r = s.length() - 1;
        while (l < r) {
            //跳过非字母数字字符
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                //不相等，则不是回文串
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                //相等，缩小边界范围
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = isPalindrome("aba");
        System.out.println(result);
    }
}
