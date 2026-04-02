class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap();

        for (int i = 0; i < beginWord.length(); i ++) {
            String key = beginWord.substring(0, i) + '*' + beginWord.substring(i + 1);
            map.compute(key, (k, v) -> {
                if (v == null) {
                    return new ArrayList(Arrays.asList(beginWord));
                } else {
                    v.add(beginWord);
                    return v;
                }
                });
        }

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i ++) {
                String key = word.substring(0, i) + '*' + word.substring(i + 1);
                map.compute(key, (k, v) -> {
                    if (v == null) {
                        return new ArrayList(Arrays.asList(word));
                    } else {
                        v.add(word);
                        return v;
                    }
                    });
            }
        }

        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        Queue<Pair<String, Integer>> q = new LinkedList();
        q.add(new Pair(beginWord, 1));
        Set<String> visited = new HashSet();

        while (!q.isEmpty()) {
            var pair = q.poll();
            String word = pair.getKey();
            int path = pair.getValue();

            if (word.equals(endWord)) {
                return path;
            }

            if (visited.contains(word)) {
                continue;
            }

            visited.add(word);
            for (int i = 0; i < word.length(); i ++) {
                String key = word.substring(0, i) + '*' + word.substring(i + 1);

                for (String neigh : map.get(key)) {
                    q.add(new Pair(neigh, path + 1));
                }
            }
        }

        return 0;
    }
}
