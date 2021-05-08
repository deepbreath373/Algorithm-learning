/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 */
public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            //如果 p 想要匹配空串，只能是包含 * 的情况，且为成对出现的（字符 + *）情况（偶数个）
            //所以，如果是奇数个则为不匹配
            if (p.length() % 2 != 0) {
                return false;
            }
            int i = 1;
            while (i < p.length()) {
                if (p.charAt(i) != '*') {
                    return false;
                }
                i += 2;
            }
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        char c1 = s.charAt(0);
        char c2 = p.charAt(0);
        char c3 = 'a';
        if(p.length() > 1){
            c3 = p.charAt(1);
        }
        if(c3 != '*'){
            if(c1 == c2 || c2 == '.'){
                return isMatch(s.substring(1),p.substring(1));
            }else{
                return false;
            }
        }else{
            if(c1 == c2 || c2 == '.'){
                return isMatch(s.substring(1),p) || isMatch(s,p.substring(2));
            }else{
                return isMatch(s,p.substring(2));
            }
        }
    }

    public static void main(String[] args) {
        String a = "123";
        System.out.println(a.substring(1));
    }
}
