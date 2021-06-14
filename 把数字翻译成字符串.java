public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length() - 1;
        char[] cs = str.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int a = cs[i] - '0';
            int b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if (a >= 0 && a <= 9) dp[i] += dp[i - 1];
            if (b >= 10 && b <= 25) {
                if (i == 1) {
                    dp[i] += dp[i - 1];
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len];
    }

    public int translateNum2(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            String temp = str.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }
}
