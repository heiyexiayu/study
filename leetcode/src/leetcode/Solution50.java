package leetcode;

public class Solution50 {
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 1;
        }
        long N=n;
        return N>0? pow2(x, N):1.0/pow2(x,-N);
    }

    private static double pow2(double x, long n) {
        if(n==0){
            return 1.0;
        }
        double v = pow2(x, n / 2);
        return n % 2 == 1? v * v * x: v * v;
    }
    public static void main(String[] args) {
        double pow = myPow(2, 3);
        System.out.println(pow);
    }
}
