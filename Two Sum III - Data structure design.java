public class TwoSum {
    Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
	public void add(int number) {
	    if(!dic.containsKey(number)) dic.put(number, 1);
	    else if(dic.get(number) == 1) dic.put(number, 2);
	}

	public boolean find(int value) {
	    for(Integer k : dic.keySet()) {
	        if(!dic.containsKey(value - k)) continue;
	        else if(value - k == k && dic.get(k) == 2) return true;
	        else if(value - k != k) return true;
	    }
	    return false;
	}
}
