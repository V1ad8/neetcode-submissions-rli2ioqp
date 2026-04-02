class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (var str : strs) {
            res = String.format("%s%d#%s", res, str.length(), str);
        }

        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList();
        int i, n;
        String miniStr;
        
        for (i = 0; i < str.length();) {
            for (n = 0; str.charAt(i) != '#'; i ++) {
                n = n * 10 + (str.charAt(i) - '0');
            }
            i ++;

            miniStr = "";
            for (; n != 0; n --, i ++) {
                miniStr = String.format("%s%c", miniStr, str.charAt(i));
            }

            res.add(miniStr);
        }

        return res;
    }
}
