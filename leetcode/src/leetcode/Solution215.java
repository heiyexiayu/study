package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution215 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        for(int j=k;j<nums.length;j++){
            queue.add(nums[j]);
            queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int [] ints={9,7,2,11,9,9,9,3,4,5,6};
        int kthLargest = findKthLargest(ints, 4);
        System.out.println(kthLargest);
    }
}
