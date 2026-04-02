class PrefixTree {
    PrefixTree[] children;
    boolean endHere;

    public PrefixTree() {
        children = new PrefixTree[26];
        endHere = false;
    }

    public void insert(String word) {
        if (word.equals("")) {
            endHere = true;
            return;
        }

        char c = word.charAt(0);
        String str = word.substring(1);
        PrefixTree child = children[c - 'a'];

        if (child == null) {
            children[c - 'a'] = new PrefixTree();
            child = children[c - 'a'];
        }

        child.insert(str);
    }

    public boolean search(String word) {
        if (word.equals("")) {
            return endHere;
        }

        char c = word.charAt(0);
        String str = word.substring(1);
        PrefixTree child = children[c - 'a'];

        if (child == null) {
            return false;
        }

        return child.search(str);
    }

    public boolean startsWith(String prefix) {
        if (prefix.equals("")) {
            return true;
        }

        char c = prefix.charAt(0);
        String str = prefix.substring(1);
        PrefixTree child = children[c - 'a'];

        if (child == null) {
            return false;
        }

        return child.startsWith(str);
    }
}
