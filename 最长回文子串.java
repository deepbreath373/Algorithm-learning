/*https://leetcode-cn.com/problems/longest-palindromic-substring/description/
	给你一个字符串 s，找到 s 中最长的回文子串。
	示例 1：
		输入：s = "babad"
		输出："bab"
		解释："aba" 同样是符合题意的答案。
	示例 2：
		输入：s = "cbbd"
		输出："bb"
	示例 3：
		输入：s = "a"
		输出："a"
	示例 4：
		输入：s = "ac"
		输出："a"
	提示：
	1 <= s.length <= 1000
	s 仅由数字和英文字母（大写和/或小写）组成*/
class Solution {
	//index: 记录回文串第一个字符的位置
	//len: 记录回文串的长度
    private int index, len;
    public String longestPalindrome(String s) {
		//当字符串长度只有一个时，最长回文串为本身
        if(s.length() < 2){
            return s;
        }
        for(int i = 0; i < s.length() - 1; i++){
			//最长回文串有偶数奇数两种情况
			//奇数：从回文串中间的一个数开始向两侧查找
            PalindromeHelper(s,i,i);
			//偶数：从回文串中间的两个数开始向两侧查找
            PalindromeHelper(s,i,i+1);
        }
		//将回文串从字符串中切分出来
        return s.substring(index, index + len);
    }
    private void PalindromeHelper(String s, int l, int r){
		//如果左右两个字符相等，则增加边界范围
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
		//如果当前查到的回文串长度大于当前所记录的长度，则替换并记录长度
        if(len < r - l - 1){
            index = l + 1;
            len = r - l - 1;
        }
    }
}
