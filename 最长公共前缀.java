import java.util.Arrays;

/**
 * Leetcode: 编写⼀个函数来查找字符串数组中的最⻓公共前缀。如果不存在公共前缀，返回
 * 空字符串 ""。
 * 输⼊: ["flower","flow","flight"]
 * 输出: "fl"
 * 输⼊: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输⼊不存在公共前缀。
 */
public class 最长公共前缀 {
    public static String replaceSpace(String[] strs){
        if(strs == null || strs.length == 0){
            return null;
        }
        //数组长度
        int len = strs.length;
        //用来保存结果
        StringBuffer res = new StringBuffer();
        //给数组元素按升序排列，这样就会让相同的前缀连续存放（有数字的排前面）
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[len-1].length();
        //最长的公共前缀只能等于短的字符串本身的长度
        int max = Math.min(m,n);
        for (int i = 0; i < max; i++) {
            //因为排序后的关系，只要找到第一个和最后一个的公共前缀就是最长的
            if(strs[0].charAt(i) == strs[len-1].charAt(i)){
                res.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"castomer","car","cat"};
        System.out.println(replaceSpace(strs));
    }
}
