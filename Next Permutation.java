public class Solution {
    public void nextPermutation(int[] num) {
        for(int i = num.length - 1; i > 0; --i) {
            if(num[i] > num[i - 1]) {
                int newHead = i;
                for(int j = i + 1; j < num.length; ++j) {
                    if(num[j] > num[i - 1] && num[j] < num[newHead]) newHead = j;
                }
                swap(num, i - 1, newHead);
                Arrays.sort(num, i, num.length);
                return;
            }
        }
        Arrays.sort(num);
    }
    private void swap(int[] num, int i1, int i2) {
        int temp = num[i1];
        num[i1] = num[i2];
        num[i2] = temp;
    }
}
