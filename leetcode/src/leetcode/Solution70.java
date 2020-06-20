package leetcode;

/**
 * @Description 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * @Author wymy
 * @date 2020.06.20 21:56
 */
public class Solution70 {
    //递归超时
    public int climbStairs1(int n) {
        if (n<=2){
            return n;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }
    //动态规划 使用临时数组
    public int climbStairs2(int n) {

        if (n<=2){
            return n;
        }
        int []arr=new int[n];
        arr[0]=1;
        arr[1]=2;
        for(int i=2;i<n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }
    //进一步优化空间，去掉数组，增加赋值操作
    public int climbStairs3(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
//数学公式
    public int climbStairs_math(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }

}
