package arithmetic.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QucikSort {
    private static int[] quickSort(int[] arr) {
        int i=0;
        int j=arr.length-1;
        quickSort(arr,i,j);
        return arr;
    }

    private static void quickSort(int[] arr, int i, int j) {
        int head=i;
        int tail=j;
        if(i>j){
            return;
        }
        int temp=arr[i];
        while(i<j){
            while(temp<=arr[j]&&j>i){//相等时也需要移动
                j--;
            }
            arr[i]=arr[j];
            while(temp>=arr[i]&&j>i){
                i++;
            }
            arr[j]=arr[i];
        }
        arr[i]=temp;
        quickSort(arr,head,i-1);
        quickSort(arr,i+1,tail);
    }

    public static void main(String[] args) {
        int arr[]={32,2,1,2,2,2,2,2};
        int[] ints = quickSort(arr);
        System.out.printf(Arrays.toString(ints));
    }
}
