class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> s_map = new HashMap();
        Map<Character, Integer> t_map = new HashMap();

        for (int i = 0; i < s.length(); i ++) {
            s_map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            t_map.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        for (char c = 'a'; c <= 'z'; c ++) {
            if (!Objects.equals(s_map.get(c), t_map.get(c))) {
                return false;
            }
        }

        return true;
    }
}
