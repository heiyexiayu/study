import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Solution1 {
    //暴力
    public static int[] twoSum1(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            int temp=target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==temp){
                    return new  int[]{i,j};
                }
            }
        }
        return null;
    }
    //hash
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        for(Integer k=0;k<nums.length;k++){
            if(map.containsKey(target-nums[k])){
                return new int[]{map.get(target-nums[k]),k};
            }
            map.put(nums[k],k);
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[]={2,3,4,7,11,15};
        int[] ints = twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));
    }


}
