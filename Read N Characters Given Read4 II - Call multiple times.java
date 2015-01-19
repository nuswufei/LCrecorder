public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] res = new char[4];
    int ressize = 0;
    int resstart = 0;
    public int read(char[] buf, int n) {
        int count = 0;
        boolean eof = false;
        while(count < n && !eof) {
            int readsize = ressize > 0 ? ressize : read4(res);
            if(ressize == 0 && readsize < 4) eof = true;
            int cur = Math.min(n - count, readsize);
            System.arraycopy(res, resstart, buf, count, cur);
            count += cur;
            ressize = readsize - cur;
            resstart = (resstart + cur) % 4;
        }
        return count;
    }
}
