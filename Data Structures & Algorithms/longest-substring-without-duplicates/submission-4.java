class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();

        int right = 0;
        int left = 0;
        int res = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right ++;
            } else {
                while(set.contains(s.charAt(right)) && left < s.length()) {
                    set.remove(s.charAt(left));
                    left ++;
                }
            }

            res = (right - left) > res ? (right - left) : res;
        }

        res = (right - left) > res ? (right - left) : res;

        return res;
    }
}
