import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import com.sun.org.apache.regexp.internal.RE;

/**
 * 整数反转
 */
public class Solution7 {
    //暴力
    public int reverse1(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }

        String s;
        char[] chars;
        if (x < 0) {
            s = -x + "";

        } else s = x + "";
        chars = s.toCharArray();
        char temp;
        for (int i = 0; i <= chars.length / 2; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        s = new String(chars);
        try {
            if (x < 0) {
                return new Integer("-" + s);
            }
            return new Integer(s);
        } catch (Exception e) {
            return 0;
        }
    }
//使用long
        public static int reverse(int x) {
            if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
                return 0;
            }
                long y = x;
                long m = 0;
                long mod = 0;
                while (y != 0) {
                    mod = y % 10;
                    m = m * 10 + mod;
                    y = y / 10;
                }
                if(m>Integer.MAX_VALUE||m<Integer.MIN_VALUE){
                    return 0;
                }
                return  (int)m;
    }

    public static void main(String[] args) {
        System.out.println(-99%10);
        int reverse = reverse(-2147483648);
        System.out.println(reverse);
    }
}
