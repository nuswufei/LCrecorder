public class Solution {
    public int findMin(int[] num) {
        if(num.length == 0) return 0;
        int left = 0;
        int right = num.length - 1;
        int last = 0;
        while (left <= right) {
            if(num[left] < num[right]) return num[left];
            int mid = (left + right) >> 1;
            last = mid;
            if(mid != 0 && num[mid] < num[mid - 1]) return num[mid];
            if(num[mid] == num[left]) ++left;
            else if(num[mid] > num[left]) left = mid + 1;
            else right = mid - 1;
        }
        return num[last];
    }
}
