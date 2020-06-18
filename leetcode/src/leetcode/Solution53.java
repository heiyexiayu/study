package leetcode;

/**
 * @Description 最大子序列和
 * @Author wymy
 * @date 2020.06.18 22:20
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int max=nums[0];//如果都为负数，保存在大的数
        int sum=0;
        int m=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            sum+=nums[i];
            if(sum<0){
                sum=0;
            }
            m=Math.max(sum,m);
        }
       if(m<=0){
           m=max;
       }
       return m;
    }
}
