public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dpT = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); ++i) dpT[i][word2.length()] = word1.length() - i;
        for(int j = 0; j <= word2.length(); ++j) dpT[word1.length()][j] = word2.length() - j;
        for(int i = word1.length() - 1; i >= 0; --i) {
            for(int j = word2.length() - 1; j >= 0; --j) {
                int min = Math.min(Math.min(dpT[i + 1][j + 1], dpT[i][j + 1]), dpT[i + 1][j]);
                dpT[i][j] = word1.charAt(i) == word2.charAt(j) ? dpT[i + 1][j + 1] : ++min;
            }
        }
        return dpT[0][0];
    }
}
