public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        char[] buf4 = new char[4];
        while(count < n) {
            int cur = read4(buf4);
            System.arraycopy(buf4, 0, buf, count, Math.min(n - count, cur));
            if(cur < 4) return Math.min(n, count + cur);
            else count += Math.min(n - count, cur);
        }
        return count;
    }
}
