public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<int[]> stk = new Stack<int[]>();
        int max = 0;
        stk.push(new int[]{-1, 0});
        for(int i = 0; i < height.length + 1; ++i) {
            if(getHeight(height, i) > stk.peek()[1]) stk.push(new int[]{i, getHeight(height, i)});
            if(getHeight(height, i) == stk.peek()[1]) {}
            else {
                int[] col = new int[2];
                while(!stk.empty() && stk.peek()[1] > getHeight(height, i)) {
                    col = stk.pop();
                    max = Math.max(max, col[1] * (i - col[0]));
                }
                stk.push(new int[] {col[0], getHeight(height, i)});
                
            }
        }
        return max;
    }
    private int getHeight(int[] height, int index) {
        if(index >= height.length) return 0;
        else return height[index];
    }
}
