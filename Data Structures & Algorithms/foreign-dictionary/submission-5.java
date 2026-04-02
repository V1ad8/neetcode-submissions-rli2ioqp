class Solution {
    public boolean dfs(char node,
            Map<Character,List<Character>> adj, Map<Character, Integer> state,
            List<Character> res) {
        if (state.containsKey(node) && state.get(node) == 1) {
            return false;
        }

        if (state.containsKey(node) && state.get(node) == 2) {
            return true;
        }

        state.put(node, 1);

        for (char neigh : adj.get(node)) {
            if (!dfs(neigh, adj, state, res)) {
                return false;
            }
        }
        state.put(node, 2);
        res.add(node);

        return true;
    }

    public char[] findDiff(String first, String second) {
        int i = 0;
        while (i < first.length() && i < second.length() && first.charAt(i) == second.charAt(i)) {
            i ++;
        }

        if (i == first.length() || i == second.length()) {
            return null;
        }

        return new char[]{first.charAt(i), second.charAt(i)};
    }

    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adj = new HashMap();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 1; i < words.length; i ++) {
            char[] d = findDiff(words[i - 1], words[i]);

            if (d == null) {
                if (words[i - 1].length() > words[i].length() && words[i - 1].startsWith(words[i])) {
                    return "";
                }
                continue;
            }

            adj.get(d[0]).add(d[1]);
        }

        Map<Character, Integer> state = new HashMap();

        List<Character> res = new ArrayList();
        for (char c : adj.keySet()) {
            if (!state.containsKey(c) || state.get(c) != 2) {
                if (!dfs(c, adj, state, res)) {
                    return "";
                }
            }
        }

        String alpha = "";
        for (int i = res.size() - 1; i >= 0; i --) {
            alpha += res.get(i);
        }

        return alpha;
    }
}
