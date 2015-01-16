public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        if(s.length() == 0) return result;
        if(dict.contains(s)) result.add(s);
        for(int i = s.length() - 1; i >= 1; --i) {
            if(dict.contains(s.substring(i))) {
                for(String pre : wordBreak(s.substring(0, i), dict)) {
                    result.add(pre + " " + s.substring(i));
                }
            }
        }
        return result;
    }
}
