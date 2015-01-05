public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int gap = Integer.MAX_VALUE;
        int result = 0;
        int ilast = num.length - 1;
        while(ilast >= 2) {
            while(ilast > 0 && ilast + 1 < num.length && num[ilast] == num[ilast + 1]) --ilast;
            int ifirst = 0;
            int imid = ilast - 1;
            while(ifirst < imid) {
                int sum = num[ifirst] + num[imid] + num[ilast];
                if(sum > target) {
                    if(gap > sum -target) {
                        gap = sum - target;
                        result = sum;
                    }
                    do{--imid;} while(imid > ifirst && num[imid] == num[imid + 1]);
                }
                else if (sum < target) {
                    if(gap > target -sum) {
                        gap = target -sum;
                        result = sum;
                    }
                    do{++ifirst;} while(imid > ifirst && num[ifirst] == num[ifirst - 1]);
                }
                else return target;
            }
            --ilast;
        }
        return result;
    }
}
