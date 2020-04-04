package leetcode;

public class Solution509 {
    //递归
    public static int fib1(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fib1(N - 1) + fib1(N - 2);
    }
    //使用数组保存  递推
    public static int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] a = new int[n + 1];
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
    //用变量代替数组
    public static int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int p = 0;
        int q = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = p;
            p = p + q;
            q = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        int fib = fib2(4);
        System.out.println(fib);
    }
}
