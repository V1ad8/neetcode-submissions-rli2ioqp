class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for (var str : strs) {
            int [] alpha = new int[26];

            for (int i = 0; i < 26; i ++) {
                alpha[i] = 0;
            }

            for (int i = 0; i < str.length(); i ++) {
                alpha[str.charAt(i) - 'a'] += 1;
            }

            String key = Arrays.toString(alpha);
            if (map.get(key) == null) {
                List<String> list = new ArrayList();
                list.add(str);

                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }

        List<List<String>> res = new ArrayList();
        for (var e : map.entrySet()) {
            res.add(e.getValue());
        }

        return res;
    }
}
