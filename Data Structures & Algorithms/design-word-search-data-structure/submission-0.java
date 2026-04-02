class WordDictionary {
    WordDictionary[] children;
    boolean endHere;

    public WordDictionary() {
        children = new WordDictionary[26];
        endHere = false;
    }

    public void addWord(String word) {
        if (word.equals("")) {
            endHere = true;
            return;
        }

        char c = word.charAt(0);
        String str = word.substring(1);
        WordDictionary child = children[c - 'a'];

        if (child == null) {
            children[c - 'a'] = new WordDictionary();
            child = children[c - 'a'];
        }

        child.addWord(str);
    }

    public boolean search(String word) {
        if (word.equals("")) {
            return endHere;
        }

        char c = word.charAt(0);
        String str = word.substring(1);

        if (c != '.') {
            WordDictionary child = children[c - 'a'];
            if (child == null) {
                return false;
            }

            return child.search(str);
        } else {
            for (int i = 0; i < 26; i ++) {
                if (children[i] != null && children[i].search(str)) {
                    return true;
                }
            }

            return false;
        }
    }
}
