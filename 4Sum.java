public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int i4 = num.length - 1;
        while(i4 > 2) {
            while(i4 > 0 && i4 + 1 < num.length && num[i4] == num[i4 + 1]) --i4;
            int i3 = i4 - 1;
            while(i3 > 1 && num[i3] + num[i4] >= ((target - 1) >> 1)) {
                while(i3 > 0 && i3 + 1 < i4 && num[i3] == num[i3 + 1]) --i3;
                int i2 = i3 - 1;
                int i1 = 0;
                while(i1 < i2) {
                    int sum = num[i1] + num[i2] + num[i3] + num[i4];
                    if(sum > target) {
                        do{--i2;} while(i2 >= i1 && num[i2] == num[i2 + 1]);
                    }
                    else if(sum < target) {
                        do{++i1;} while (i1 <= i2 && num[i1] == num[i1 - 1]);
                    }
                    else {
                        List<Integer> oneSol = new ArrayList<Integer>();
                        oneSol.add(num[i1]);
                        oneSol.add(num[i2]);
                        oneSol.add(num[i3]);
                        oneSol.add(num[i4]);
                        result.add(oneSol);
                        do{--i2;} while(i2 >= i1 && num[i2] == num[i2 + 1]);
                        do{++i1;} while (i1 <= i2 && num[i1] == num[i1 - 1]);
                    }
                }
                --i3;
            }
            --i4;
        }
        return result;
    }
}
