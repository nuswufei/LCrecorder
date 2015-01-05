public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letterTable = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<String>();
        List<StringBuilder> resultSB= new ArrayList<StringBuilder>();
        resultSB.add(new StringBuilder());
        for(int id = 0; id < digits.length(); ++id){
            int num = Integer.parseInt(digits.charAt(id) +"");
            int size = resultSB.size();
            for(int isb = 0; isb < size; ++isb) {
                for(int ichar = 0; ichar < letterTable[num].length(); ++ichar) {
                    StringBuilder sb = new StringBuilder(resultSB.get(0));
                    sb.append(letterTable[num].charAt(ichar));
                    resultSB.add(sb);
                }
                resultSB.remove(0);
            }
        }
        for(StringBuilder sb : resultSB) {
            result.add(sb.toString());
        }
        return result;
    }
}
