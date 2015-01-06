public List<String> generateParenthesis(int n) {
        Map<StringBuilder, Integer> resultSB = new HashMap<StringBuilder, Integer>();
        resultSB.put(new StringBuilder(), 0);
        for(int i = 0; i < n * 2; ++i) {
            Map<StringBuilder, Integer> stepSB = new HashMap<StringBuilder, Integer>();
            for(StringBuilder sb : resultSB.keySet()) {
                int leftCount = resultSB.get(sb);
                if(2 * n - i >= leftCount) {
                    if(leftCount > 0) {
                        StringBuilder sbtemp = new StringBuilder(sb);
                        sbtemp.append(')');
                        stepSB.put(sbtemp, leftCount - 1);
                    }
                    StringBuilder sbtemp = new StringBuilder(sb);
                    sbtemp.append('(');
                    stepSB.put(sbtemp, leftCount + 1);
                }
            }
            resultSB = stepSB;
        }
        List<String> result = new ArrayList<String>();
        for(StringBuilder sb : resultSB.keySet()) {
            if(resultSB.get(sb) == 0) result.add(sb.toString());
        }
        return result;
    }
