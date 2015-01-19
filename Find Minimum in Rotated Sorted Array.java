public class Solution {
    public int findMin(int[] num) {
        if(num.length == 0) return 0;
        int left = 0;
        int right = num.length  - 1;
        while(left <= right) {
            if(num[left] < num[right]) return num[left];
            int mid = (left + right) >> 1;
            if(isMin(num, mid)) return num[mid];
            if(num[left] <= num[mid]) left = mid + 1;
            else right  = mid - 1;
        }
        return num[0];
    }
    boolean isMin(int[] num, int i) {
        int pre = i == 0 ? num.length - 1 : i - 1;
        int post = i == num.length - 1 ? 0 : i + 1;
        return num[i] <= num[post] && num[i] <= num[pre];
    }
}
