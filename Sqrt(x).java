public class Solution {
    public int sqrt(int x) {
        int left = 1;
        int right = x;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(x / mid == mid ||(x / mid > mid && x / (mid + 1) < (mid + 1))) return mid;
            if(x / mid > mid) left = mid + 1;
            else right = mid  - 1;
        }
        return 0;
    }
}
