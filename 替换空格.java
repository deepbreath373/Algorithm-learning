/*剑指offer：请实现⼀个函数，将⼀个字符串中的每个空格替换成“%20”。例如，当字符串为
        We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/
public class 替换空格 {
    public static String replaceSpace(StringBuffer str){
        int length = str.length();
        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char b = str.charAt(i);
            if(String.valueOf(b).equals(" ")){
                answer.append("%20");
            }else{
                answer.append(b);
            }
        }
        return answer.toString();
    }

    public static String replaceSpace2(StringBuffer str){
        return str.toString().replace(" ","%20");
    }

    public static void main(String[] args) {
        String str = "we are happy";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String s = replaceSpace2(stringBuffer);
        System.out.println(s);
    }
}
