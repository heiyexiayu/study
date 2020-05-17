package arithmetic.sort;

import java.util.Arrays;
import java.util.Date;

public class HeapSort {

    public static int []heapsort(int []nums){
    //构造堆
        int l=nums.length;
        for(int i=l/2-1;i>=0;i--){
            adjust(nums,i,l);
        }
        //调整为堆
        for(int j=l-1;j>=0;j--){
            swap(nums,0,j);
            adjust(nums,0,j);
        }
        return nums;
    //
    }

    private static void adjust(int[] nums, int i,int l) {
        int temp=nums[i];

        for(int k=2*i+1;k<l;k=2*k+1){
            if(k+1<l&&nums[k]<nums[k+1]){
                k++;
            }
            if(nums[k]>temp){
                nums[i]=nums[k];
                i=k;
            }else break;
        }
       nums[i]=temp;
    }

    public static void swap(int []nums ,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
}

    public static void main(String[] args) {
        int []arr1= {10,1,7,8,4,7,4,8,3,5,9};
        heapsort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
//
//    public static void sort(int []arr){
//        //构建最大堆（初始化）从最后一个非叶子节点开始
//        for(int i=(arr.length)/2-1;i>=0;i--){
//            partAdjust(arr,i,arr.length);
//        }
//        //将最大值交换到末尾 并调整剩下成为最大堆
//        for(int j=arr.length-1;j>=0;j--){
//            swap(arr,0,j);
//            partAdjust(arr,0,j);
//        }
//
//    }
//    //局部调整 使父节点的值比左右节点大
//    public static void partAdjust(int []arr,int i,int length){
//        int temp=arr[i];
//        //每次都跳到左节点
//        for( int k=2 * i + 1;k<length;k=2*k+1){
//            //选出左右节点较大的值    k+1<length原因是如果不存在右节点k+1会越界
//            if (k+1<length&&arr[k] <arr[ k+1]) {
//                k++;
//            }
//            //如果子节点中的值比父节点大 将值赋给父节点 并且调整节点指向下一个左节点
//            if(temp<arr[k]){
//                arr[i]=arr[k];
//                i=k;
//            }
//            //在最大堆的条件下 如果父节点值比子节点都大，就不需要再往下比较
//            else break;
//
//        }
//        //最终temp存放的值的位置
//        arr[i]=temp;
//
//    }
//    public static void swap(int[]arr,int a,int b) {
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }
//
//    //main函数
//    public static void main(String[] args) {
//        int []arr1= {10,1,7,8,4,7,4,8,3,5,9};
//        int arr[]=new int[100000];
//        int j=0;
//        for(int i=arr.length-1;i>=0;i--){
//            arr[i]=j;
//            j++;
//        }
//        sort(arr1);
//        System.out.println(Arrays.toString(arr1));
//        System.out.println("----------");
//        System.out.println(new Date().getTime());
//        sort(arr);
//        System.out.println(new Date().getTime());
//        System.out.println(Arrays.toString(arr));
//    }
}
