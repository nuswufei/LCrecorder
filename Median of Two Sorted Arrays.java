public class Solution {
	 public double findMedianSortedArrays(int A[], int B[]) {
    	int astart = 0;
	     int aend = A.length - 1;
	     int bstart = 0;
	     int bend = B.length - 1;
	     while(aend - astart > 1 && bend - bstart > 1) {
	    	 int excludeLength = Math.min((aend - astart) >> 1, (bend - bstart) >> 1);
	         if(A[(astart + aend) >> 1] < B[(bstart + bend) >> 1]) {	        	 
	             bend -= excludeLength;
	             astart += excludeLength;
	         } else {
	             aend -= excludeLength;
	             bstart += excludeLength;
	         }
	     }
	     return A.length > B.length ? getMid(B, bstart, bend, A, astart, aend) : getMid(A, astart, aend, B, bstart, bend);	     
	}
    private double getMid(int[] S, int sstart, int send, int[] L, int lstart, int lend) {
	     List<Integer> candidator = new ArrayList<Integer>();
	     for(int i = sstart; i <= send; ++i) candidator.add(S[i]);
	     int lmid = (lstart + lend) >> 1;
	     candidator.add(lmid - 1 < 0 ? Integer.MIN_VALUE : L[lmid - 1]);
	     candidator.add(L[lmid]);
	     candidator.add(lmid + 1 >= L.length ? Integer.MAX_VALUE : L[lmid + 1]);
	     if((lstart - lend + 1) % 2 == 0) candidator.add(lmid + 2 >= L.length ? Integer.MAX_VALUE : L[lmid + 2]);
	     Collections.sort(candidator);
	     return candidator.size() % 2 == 1 ? candidator.get(candidator.size() / 2) : (candidator.get(candidator.size() / 2) + candidator.get(candidator.size() / 2 - 1)) / 2.0;
    }
}
