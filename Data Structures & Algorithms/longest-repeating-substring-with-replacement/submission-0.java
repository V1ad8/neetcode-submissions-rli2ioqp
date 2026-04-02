class Solution {
    private int bestCount(Map<Character, Integer> map) {
        int res = 0;
        for (var e : map.entrySet()) {
            if (e.getValue() > res) {
                res = e.getValue();
            }
        }

        return res;
    }

    public int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }

        int res = 1;

        Map<Character, Integer> map = new HashMap();
        int maxCount = 1;
        map.put(s.charAt(0), 1);

        int right = 0;
        int left = 1;
        int currentSize = 1;
        char c;

        while (left < s.length()) {
            c = s.charAt(left);
            map.compute(c, (key, v) -> v == null ? 1 : v + 1);
            if (map.get(c) > maxCount) {
                maxCount = map.get(c);
            }

            left ++;
            currentSize ++;

            while (maxCount + k < currentSize) {
                c = s.charAt(right);
                map.compute(c, (key, v) -> v - 1);

                maxCount = bestCount(map);
                currentSize --;
                right ++;
            }

            if (currentSize > res) {
                res = currentSize;
            }
        }

        return res;

    }
}
