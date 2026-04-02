class Solution {
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> explore(String s, int start, List<String> list) {
        List<List<String>> res = new ArrayList();

        if (start == s.length()) {
            res.add(new ArrayList(list));
            return res;
        }

        for (int end = start; end < s.length(); end ++) {
            if (isPalindrome(s, start, end)) {
                list.add(s.substring(start, end + 1));
                res.addAll(explore(s, end + 1, list));
                list.remove(list.size() - 1);
            }
        }

        return res;
    }

    public List<List<String>> partition(String s) {
        return explore(s, 0, new ArrayList());
    }
}
