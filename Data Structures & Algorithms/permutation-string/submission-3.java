class Solution {
    public boolean same(int[] reference, int[] map) {
        for (int i = 0; i < 26; i ++) {
            if (reference[i] != map[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] reference = new int[26];
        int[] map = new int[26];

        int n = s1.length();
        if (s2.length() < n) {
            return false;
        }

        for (int i = 0; i < n; i ++) {
            reference[s1.charAt(i) - 'a'] ++;
            map[s2.charAt(i) - 'a'] ++;
        }

        int left = 0;
        int right = n;

        while (right < s2.length()) {
            if (same(reference, map)) {
                return true;
            }

            map[s2.charAt(right) - 'a'] ++;
            map[s2.charAt(left) - 'a'] --;
            right ++;
            left ++;
        }

        if (same(reference, map)) {
            return true;
        }

        return false;
    }
}
