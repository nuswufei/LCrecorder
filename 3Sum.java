public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int ilast = num.length - 1;
        while(ilast >= 2 && num[ilast] >= 0) {
            while(ilast > 0 && ilast + 1 < num.length && num[ilast] == num[ilast + 1]) {
                --ilast;
            }
            int ifirst = 0;
            int imid = ilast - 1;
            while(ifirst < imid) {
                if(num[ifirst] + num[imid] + num[ilast] > 0) {
                    do{--imid;} while(imid > ifirst && num[imid] == num[imid + 1]);
                }
                else if(num[ifirst] + num[imid] + num[ilast] < 0) {
                    do{++ifirst;} while(imid > ifirst && num[ifirst] == num[ifirst - 1]);
                }
                else {
                    List<Integer> oneSol = new ArrayList<Integer>();
                    oneSol.add(num[ifirst]);
                    oneSol.add(num[imid]);
                    oneSol.add(num[ilast]);
                    result.add(oneSol);
                    do{--imid;} while(imid > ifirst && num[imid] == num[imid + 1]);
                    do{++ifirst;} while(imid > ifirst && num[ifirst] == num[ifirst - 1]);
                }
            }
            --ilast;
        }
        return result;
    }
}
