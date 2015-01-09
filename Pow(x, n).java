public class Solution {
    public double pow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n < 0) return 1 / (pow(x, - 1 -n) * x);
        double half = pow(x, n / 2);
        return half * half * pow(x, n & 1);
    }
}
