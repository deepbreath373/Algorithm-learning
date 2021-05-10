/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 数值（按顺序）可以分成以下几个部分：
 *
 *     若干空格
 *     一个 小数 或者 整数
 *     （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 *     若干空格
 *
 * 小数（按顺序）可以分成以下几个部分：
 *
 *     （可选）一个符号字符（'+' 或 '-'）
 *     下述格式之一：
 *         至少一位数字，后面跟着一个点 '.'
 *         至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 *         一个点 '.' ，后面跟着至少一位数字
 *
 * 整数（按顺序）可以分成以下几个部分：
 *     （可选）一个符号字符（'+' 或 '-'）
 *     至少一位数字
 * 部分数值列举如下：
 *     ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 *     ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 */
public class 表示数值的字符串 {
    /*数字出现的位置无限制
      点只能出现一次，且不能再'e'后面
      'e'必须在数字中间，且只有一次
      正负号在开头或者'e'后面
     */
    public boolean isNumber(String s) {
        if (s.length() == 0 || s == null) {
            return false;
        }
        //去掉字符串中首位空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判断数字位
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
            }
            //如果当前位为'.'，要求没出现过且之前没有'e'
            else if (s.charAt(i) == '.' && !eFlag && !dotFlag) {
                dotFlag = true;
            }
            //如果当前位为'e'，要求没出现过且前后为数字
            else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                //保证之后也有数字出现
                numFlag = false;
            }
            //如果当前位为'+' | '-'，要求在开头或者'e'后面
            else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

            }
            //其他情况均非数字
            else {
                return false;
            }
        }
        return numFlag;
    }
}
