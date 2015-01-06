public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if(L.length == 0) return result;
        Map<String, Integer> dic = getMap(L);
        int dicSize = L.length;
        int wordLength = L[0].length();
        for(int i = 0; i < wordLength; ++i) {
            search(i, S, dic, dicSize, result, wordLength);
        }
        return result;
    }
    private void search(int i, String s, Map<String, Integer> dic, int dicSize, List<Integer> result, int wordLength) {
        while(i <= s.length() - dicSize * wordLength) {
            Map<String, Integer> dicCopy = new HashMap<String, Integer>(dic);
            int count = dicSize;
            int index = i;
            while(count > 0) {
                String key = s.substring(index, index + wordLength);
                if(dicCopy.containsKey(key) && dicCopy.get(key) > 0) {
                    index += wordLength;
                    dicCopy.put(key, dicCopy.get(key) - 1);
                    --count;
                }
                else if(!dicCopy.containsKey(key)) {
                    i = index + wordLength;
                    break;
                }
                else {
                    while(!s.substring(i, i + wordLength).equals(key)) i += wordLength;
                    i += wordLength;
                    break;
                }
            }
            if(count == 0) {
                result.add(i);
                i = i + wordLength;
            }
        }
    }
    private HashMap<String, Integer> getMap(String[] L) {
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        for(String s : L) {
            if(resultMap.containsKey(s)) resultMap.put(s, resultMap.get(s) + 1);
            else resultMap.put(s, 1);
        }
        return resultMap;
    }
}
