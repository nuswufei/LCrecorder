public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<String, List<String>>();
        for(String str : strs) {
            int[] signature = new int[26];
            for(int i  = 0; i < str.length(); ++i) ++signature[str.charAt(i) - 'a'];
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < signature.length; ++i) sb.append(('a' + i) + "" + signature[i]);
            if(result.containsKey(sb.toString())) result.get(sb.toString()).add(str);
            else {
                List<String> lst = new ArrayList<String>();
                lst.add(str);
                result.put(sb.toString(), lst);
            }
        }
        List<String> resultLst = new ArrayList<String>();
        for(String str : result.keySet()) {
            if(result.get(str).size() > 1) resultLst.addAll(result.get(str));
        }
        return resultLst;
    }
}
