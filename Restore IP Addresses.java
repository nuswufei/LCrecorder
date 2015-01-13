public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<StringBuilder> resultSB = new ArrayList<StringBuilder>();
        StringBuilder sb = new StringBuilder();
        dfs(s, resultSB, sb, 0, 0);
        List<String> result = new ArrayList<String>();
        for(StringBuilder oneSB : resultSB) {
            result.add(oneSB.toString().substring(0, oneSB.length() - 1));
        }
        return result;
    }
    private void dfs(String s, List<StringBuilder> resultSB, StringBuilder sb, int curIndex, int curSeg) {
        if(curSeg == 4 && curIndex == s.length()) {
            resultSB.add(sb);
            return;
        }
        if(curSeg > 4 || curIndex >= s.length()) return;
        StringBuilder sbCopy = new StringBuilder(sb);
        sbCopy.append(s.substring(curIndex, curIndex + 1) + ".");
        dfs(s, resultSB, sbCopy, curIndex + 1, curSeg + 1);
        if(curIndex + 2 <= s.length() && Integer.parseInt(s.substring(curIndex, curIndex + 2)) > 9) {
            sbCopy = new StringBuilder(sb);
            sbCopy.append(s.substring(curIndex, curIndex + 2) + ".");
            dfs(s, resultSB, sbCopy, curIndex + 2, curSeg + 1);
        }
        if(curIndex + 3 <= s.length()) {
            int num = Integer.parseInt(s.substring(curIndex, curIndex + 3));
            if(num < 256 && num > 99) {
                sbCopy = new StringBuilder(sb);
                sbCopy.append(s.substring(curIndex, curIndex + 3) + ".");
                dfs(s, resultSB, sbCopy, curIndex + 3, curSeg + 1);
            }
        }
    }
}
