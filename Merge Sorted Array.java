public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        for(int i = m - 1; i >= 0; --i) A[n + i] = A[i];
        int itA = 0;
        int itB= 0;
        int it = 0;
        while(itA < m && itB < n) {
            A[it++] = A[n + itA] < B[itB] ? A[n + itA++] : B[itB++];
        }
        while(itB < n) A[it++] = B[itB++];
    }
}
