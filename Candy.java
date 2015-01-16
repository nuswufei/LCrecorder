public class Solution {
    public int candy(int[] ratings) {
        int[] num = new int[ratings.length];
        num[0] = 1;
        for(int i = 1; i < ratings.length; ++i) {
            if(ratings[i] > ratings[i - 1]) num[i] = num[i - 1] + 1;
            else num[i] = 1;
        }
        for(int i = ratings.length - 2; i >= 0; --i) {
            if(ratings[i] > ratings[i + 1]) num[i] = Math.max(num[i], num[i + 1] + 1);
        }
        int result = 0;
        for(int i : num) result += i;
        return result;
    }
}
