package leetcode;

/**
 * 4. 寻找两个有序数组的中位数
 */
public class Solution4 {


    public static void main(String[] args) {
       int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    //log（m+n）
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    //i: nums1的起始位置 j: nums2的起始位置
    public static int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }
//m+n
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        //目标位置  对于偶数则表示中位数后一个值的位置   对于奇数则表示目标位置
        int target = (m + n) / 2 ;
        //总数长度的奇偶标志
        int reminder = (m + n) % 2;
        //循环数组1 辅助计数
        int i = 0;
        //循环数组2 辅助计数
        int j = 0;
        //寻找目标参数位置 辅助计数
        int k = 0;
       //总长为偶数表示中位数左边的值
        int left = 0;
        //偶数：中位数右边的值     奇数：中位数的值
        int right = 0;
        while (k <= target && i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                if (k == target - 1) {//保存左边的值
                    left = nums1[i];
                }
                if (k == target) {//保存右边的值
                    right = nums1[i];
                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (k == target - 1) {
                    left = nums2[j];
                }
                if (k == target) {
                    right = nums2[j];
                }
                j++;
            }
            k++;
        }
        while (k <= target && i < m) {
            if (k == target - 1) {
                left = nums1[i];
            }
            if (k == target) {
                right = nums1[i];
            }
            k++;
            i++;

        }
        while (k <= target && j < n) {
            if (k == target - 1) {
                left = nums2[j];
            }
            if (k == target) {
                right = nums2[j];
            }
            k++;
            j++;
        }
        if (reminder == 0) {
            return ((double)right + (double)left) / 2;
        } else {
            return (double)right;
        }
    }
}
