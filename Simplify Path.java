public class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        List<String> lst = new ArrayList<String>();
        for(int i = 0; i < strs.length; ++i) {
            if(strs[i].equals("..") && lst.size() != 0) lst.remove(lst.size() - 1);
            else if(!strs[i].equals(".") && !strs[i].equals("..") && strs[i].length() > 0) lst.add(strs[i]);
        }
        StringBuilder result = new StringBuilder();
        for(String s : lst) {
            result.append("/");
            result.append(s);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
