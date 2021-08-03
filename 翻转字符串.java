public class 翻转字符串 {
    public String reverseWords(String s) {
        s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0){
            while(i>=0 && s.charAt(i) != ' '){
                i--;
            }
            res.append(s.substring(i+1,j+1) + " ");
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }

    public String reverseWords2(String s) {
        String[] strs = s.trim().split(" ");
        int len = strs.length;
        StringBuilder res = new StringBuilder();
        for (int i = len-1; i >= 0; i--){
            if(strs[i].equals(" ")){
                continue;
            }
            res.append(strs[i]+" ");
        }
        return res.toString().trim();
    }
}
