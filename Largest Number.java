public class Solution {
    public String largestNumber(int[] num) {
        String[] strs = new String[num.length];
        for(int i = 0; i < num.length; ++i) {
            strs[i] = num[i] + "";
        }
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        };
        Arrays.sort(strs, comp);
        StringBuilder result = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; --i) {
            result.append(strs[i]);
        }
        String s = result.toString();
        return s.charAt(0) == '0' ? "0" : s;
    }
}
