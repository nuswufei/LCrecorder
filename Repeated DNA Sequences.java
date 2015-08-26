public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> dic = new HashSet<Integer>();
        Set<Integer> repeat = new HashSet<>();
        List<String> res = new ArrayList<>();
        if(s.length() < 11) return res;
        String dna = "ACTG";
        int mod = (1 << 20) - 1;
        int cur = 0;
        for(int i = 0; i < 10; ++i) {
            cur <<= 2;
            cur += dna.indexOf(s.charAt(i));
        }
        dic.add(cur);
        for(int i = 10; i < s.length(); ++i) {
            cur <<= 2;
            cur += dna.indexOf(s.charAt(i));
            cur &= mod;
            if(dic.contains(cur)) repeat.add(cur);
            else dic.add(cur);
        }
        for(int n : repeat) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 20; i += 2) {
                sb.append((dna.charAt((n >> i) & 3)));
            }
            res.add(sb.reverse().toString());
        }
        return res;
    }
}
