package leetcode;

/**
 * @Description 回文数字
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @Author wymy
 * @date 2020.06.18 21:53
 */
public class Solution9 {
    public static boolean isPalindrome(int x) {
        if((x!=0&&x%10==0)||x<0){
            return false;
        }
        int halfReverse=0;
        while(x>halfReverse){
            halfReverse=(x%10)+halfReverse*10;
            x=x/10;
        }
        if(x==halfReverse||(x==halfReverse/10)){
            return true;
        }
        return false;
    }
}
