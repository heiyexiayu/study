package leetcode;

import java.util.Arrays;

/**
 * 最长公共前缀
 */
public class Solution14 {
    //先对数组排序，只比较第一个和最后一个元素公共前缀就是结果
    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) { //空数组返回空串
            return "";
        }
        if (strs.length == 1) {//只有一个元素，直接返回
            return strs[0];
        }
        Arrays.sort(strs);//排序
        char[] chars = strs[strs.length - 1].toCharArray();
        char[] chars1 = strs[0].toCharArray();
        int min=Math.min(chars.length,chars1.length);//取最小的长为for循环的边界
        if (min == 0) {
            return "";
        }
        int i = 0;
        for (i = 0; i < min; i++) {
            if (chars[i] != chars1[i]) {
                break;
            }
        }
        char[] temp = new char[i];//公共前缀
        for (int j = 0; j < i; j++) {
            temp[j] = chars[j];
        }
        return new String(temp);
    }

    public static void main(String[] args) {
        String[] strings = {"a", "a"};
        //  Arrays.sort(strings);
        longestCommonPrefix(strings);
    }
}
