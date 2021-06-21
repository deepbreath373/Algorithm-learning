import java.util.HashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        int len = s.length();
        char res = ' ';
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, false);
                continue;
            }
            map.put(c, true);
        }
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i))) {
                res = s.charAt(i);
                break;
            }
        }
        return res;
    }

    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : sc) {
            if (map.get(c)) return c;
        }
        return ' ';
    }
}
