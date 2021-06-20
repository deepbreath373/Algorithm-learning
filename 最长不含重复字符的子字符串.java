import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的子字符串 {
    //dp + HashMap
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 1;
        }
        int[] dp = new int[s.length()];
        int max = 1;
        Map<Character, Integer> dic = new HashMap<>();
        dp[0] = 1;
        dic.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            int j = dic.getOrDefault(s.charAt(i), -1);
            dic.put(s.charAt(i), i);
            if (i - j > dp[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else if (i - j <= dp[i - 1]) {
                dp[i] = i - j;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = dic.getOrDefault(s.charAt(i), -1);
            dic.put(s.charAt(i), i);
            tmp = tmp < i - j ? tmp + 1 : i - j;
            res = Math.max(res, tmp);
        }
        return res;
    }

    //双指针 + HashMap
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, j = -1;
        for (int i = 0; i < s.length(); i++) {
            if (dic.containsKey(s.charAt(i))) {
                j = Math.max(j, dic.get(s.charAt(i)));
            }
            dic.put(s.charAt(i), i);
            res = Math.max(res, i - j);
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring(" ");
    }
}
