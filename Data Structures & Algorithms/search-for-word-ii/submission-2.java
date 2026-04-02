class Trie {
    Trie[] children;
    String str;

    public Trie() {
        children = new Trie[26];
        str = null;
    }

    public void insert(String word) {
        Trie child, curr = this;
        char c;

        for (int idx = 0; idx < word.length(); idx ++, curr = child) {
            c = word.charAt(idx);
            child = curr.children[c - 'a'];

            if (child == null) {
                curr.children[c - 'a'] = new Trie();
                child = curr.children[c - 'a'];
            }
        }

        curr.str = word;
    }

    public boolean search(String word) {
        Trie child, curr = this;
        char c;

        for (int idx = 0; idx < word.length(); idx ++, curr = child) {
            c = word.charAt(idx);
            child = curr.children[c - 'a'];

            if (child == null) {
                return false;
            }
        }

        return curr.str.equals(word);
    }
}



class Solution {
    public List<String> explore(char[][] board, int i, int j, Trie t) {
        List<String> res = new ArrayList();

        char c = board[i][j];
        if (c == '#' || t.children[c - 'a'] == null) {
            return res;
        }

        t = t.children[c - 'a'];
        if (t.str != null) {
            res.add(t.str);
            t.str = null;
        }

        board[i][j] = '#';

        if (i > 0) {
            res.addAll(explore(board, i - 1, j, t));
        }

        if (j > 0) {
            res.addAll(explore(board, i, j - 1, t));
        }

        if (i < board.length - 1) {
            res.addAll(explore(board, i + 1, j, t));
        }

        if (j < board[0].length - 1) {
            res.addAll(explore(board, i, j + 1, t));
        }

        board[i][j] = c;

        return res;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();

        for (var word : words) {
            t.insert(word);
        }

        List<String> res = new ArrayList();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                res.addAll(explore(board, i, j, t));
            }
        }

        return res;
    }
}
