public String fractionToDecimal(int numerator, int denominator) {
        int sign = ((numerator < 0) ^ (denominator < 0 )) ? -1 : 1;
        long deno = Math.abs((long)denominator);
        long numer = Math.abs((long) numerator);
        long res = numer % deno * 10;
        long cur = numer / deno;
        if(res == 0) return (cur * sign) + "";
        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        StringBuilder result = new StringBuilder(cur + ".");
        if(sign == -1) result.insert(0, '-');
        int position = result.length();
        while(res != 0 && !hm.containsKey(res)) {
            hm.put(res, position++);
            result.append(res / deno + "");
            res = res % deno * 10;
        }
        if(res == 0) return result.toString();
        result.append(')');
        result.insert((int)hm.get(res), '(');
        if(sign == -1) result.insert(0, "-");
        return result.toString();
    }
