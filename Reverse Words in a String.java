public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; --i) {
            if(words[i].length() == 0) continue;
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.length() == 0? sb.toString() : sb.substring(0, sb.length() - 1);
    }
}
