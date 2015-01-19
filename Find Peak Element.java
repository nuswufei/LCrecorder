public class Solution {
    public int findPeakElement(int[] num) {
        int left = 0;
        int right = num.length  - 1;
        int last = 0;
        while(left <= right) {
            int mid = (left + right) >> 1;
            last = mid;
            if((mid == left || num[mid] > num[mid - 1]) && (mid == right || num[mid] > num[mid + 1])) return mid;
            if(!(mid == left || num[mid] > num[mid - 1])) right = mid - 1;
            else left = mid + 1;
        }
        return last;
    }
}
