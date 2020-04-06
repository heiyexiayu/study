package leetcode;
//63. 不同路径
public class Solution62 {
    public static int uniquePaths(int m, int n) {
        int [][]arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    arr[i][j]=1;
                }else {
                    arr[i][j]=arr[i-1][j]+arr[i][j-1];
                }
            }
        }
        return arr[m-1][n-1];
    }
    //C（m,n）公式   只要向右m步，向下n步就能到达
    public static int uniquePaths2(int m, int n) {
        if(m==1||n==1){
            return 1;
        }
        long a=m+n-2;
        long a1=a;
        long b=Math.min(m-1,n-1);
        long c=1;
        long c1=c;
        for(int i=0;i<b-1;i++){
            a*=(--a1);
            c*=(++c1);
        }
        long result=a/c;
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(10,10));
    }
}
