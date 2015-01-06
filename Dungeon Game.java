public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0) return 0;
        int[][] dpTable = new int[dungeon.length][dungeon[0].length];
        dpTable[dungeon.length - 1][dungeon[0].length - 1] = Math.max(1, 1 - dungeon[dungeon.length - 1][dungeon[0].length - 1]);
        for(int i = dungeon[0].length - 2; i >= 0; --i) {
            dpTable[dungeon.length - 1][i] = Math.max(1, dpTable[dungeon.length - 1][i + 1] - dungeon[dungeon.length - 1][i]);
        }
        for(int i = dungeon.length - 2; i >= 0; --i) {
            dpTable[i][dungeon[0].length - 1] = Math.max(1, dpTable[i + 1][dungeon[0].length - 1] - dungeon[i][dungeon[0].length - 1]);
        }
        for(int i = dungeon.length - 2; i >= 0; --i) {
            for(int j = dungeon[0].length - 2; j >=0; --j) {
                dpTable[i][j] = Math.min(Math.max(1, dpTable[i+1][j] - dungeon[i][j]), Math.max(1, dpTable[i][j+1] - dungeon[i][j]));
            }
        }
        return dpTable[0][0];
    }
}
