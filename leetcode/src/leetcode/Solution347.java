package leetcode;

import java.util.*;

public class Solution347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //统计出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //创建最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        //构成最小堆
        for (Integer i : map.keySet()) {
            priorityQueue.add(i);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        //返回数组
        int[] result = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            result[i++] = priorityQueue.poll();
        }
        return result;

    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 1, 4, 4, 43, 7, 1, 7, 2, 2, 2, 1, 1, 2, 7, 1, 4, 1, 7, 7, 8};
        System.out.println(Arrays.toString(topKFrequent(nums, 3)));
    }
}
