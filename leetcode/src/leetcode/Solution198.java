package leetcode;

/**
 * 198.打家劫舍
 */
public class Solution198 {
    public static int rob(int[] nums) {
        //用原数组存放当前最大值
        // 最小子问题{a,b,c,d}  d位置 最大值为c,ad,bd中最大的一个
        //所以特殊情况数组长度为3以下
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        if (nums.length == 3) {
            return nums[0] + nums[2] > nums[1] ? nums[0] + nums[2] : nums[1];
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == 1) {
                continue;
            } else if (i == 2) {
                nums[i] = nums[0] + nums[2] > nums[1] ? nums[0] + nums[2] : nums[1];
            } else {
                int ad = nums[i - 3] + nums[i];
                int bd = nums[i - 2] + nums[i];
                max = Math.max(Math.max(ad, bd), nums[i - 1]);
                nums[i] = max;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        int rob = rob(nums);
        System.out.println(rob);
    }
}
