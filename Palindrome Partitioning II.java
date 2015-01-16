public class Solution {
   public int minCut(String s) {
       char[] arr= new char[s.length() * 2 + 1];
       for(int i = 0; i < arr.length; ++i) {
           if((i & 1) == 0) arr[i] = '.';
           else arr[i] = s.charAt(i >> 1);
       }
       int[] dpt = new int[arr.length + 1];
       for(int i = 0; i < dpt.length; ++i) dpt[i] = i;
       for(int i = 0; i < dpt.length; ++i) {
           int j = 0;
           while(i - j >= 0 && i + j < arr.length && arr[i + j] == arr[i - j]) {
               dpt[i + j + 1] = Math.min(dpt[i + j + 1], dpt[i - j] + 1);
               ++j;
           }
       }
       return Math.min(dpt[dpt.length - 2], dpt[dpt.length - 1])- 1;
   }
}
