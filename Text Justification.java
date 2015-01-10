public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if(words.length == 0) return result;
        List<Integer> line = new ArrayList<Integer>();
        for(int i = 0; i < words.length; ) {
            line.add(i);
            int leftLength = L - words[i++].length();
            while(i < words.length && leftLength >= words[i].length() + 1) leftLength -= words[i++].length() + 1;
        }
        for(int i = 0; i < line.size() - 1; ++i) {
            int totalLength = 0;
            StringBuilder sb = new StringBuilder(words[line.get(i)]);
            if(line.get(i + 1) - line.get(i) == 1) {
                addSpace(sb, L - sb.length());
            } else {
                for(int index = line.get(i); index < line.get(i + 1); ++index) totalLength += words[index].length();
                int base = (L - totalLength) / (line.get(i + 1) - line.get(i) - 1);
                int extra = (L - totalLength) % (line.get(i + 1) - line.get(i) - 1);
                for(int index = 1; index < line.get(i + 1) - line.get(i); ++index) {
                    if(index <= extra) addSpace(sb, base + 1);
                    else addSpace(sb, base);
                    sb.append(words[line.get(i) + index]);
                }
            }
            result.add(sb.toString());
        }
        StringBuilder sb = new StringBuilder(words[line.get(line.size() - 1)]);
        for(int i = line.get(line.size() - 1) + 1; i< words.length; ++i) {
            addSpace(sb, 1);
            sb.append(words[i]);
        }
        addSpace(sb, L - sb.length());
        result.add(sb.toString());
        return result;
    }
    private void addSpace(StringBuilder sb, int n) {for(int i = 0; i < n; ++i) sb.append(" ");}
}
