class Solution {
    public boolean valid(Map<Character, Integer> reference, Map<Character, Integer> map) {
        for (var e : reference.entrySet()) {
            if (!map.containsKey(e.getKey()) || map.get(e.getKey()) < e.getValue()) {
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> reference = new HashMap();
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < t.length(); i ++) {
            reference.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        int left = 0;
        int right = 0;
        String res = "";
        while (left < s.length()) {
            if (valid(reference, map)) {
                System.out.println(s.substring(left, right));

                if (right - left < res.length() || res.length() == 0) {
                    System.out.println();
                    res = s.substring(left, right);
                }

                map.compute(s.charAt(left), (k, v) -> v - 1);
                left ++;
            } else {
                if (right < s.length()) {
                    map.compute(s.charAt(right), (k, v) -> v == null ? 1 : v + 1);
                    right ++;
                } else {
                    break;
                }
            }
        }

        if (valid(reference, map) && (left - right < res.length() || res.length() == 0)) {
            res = s.substring(left, right);
        }

        return res;
    }
}
