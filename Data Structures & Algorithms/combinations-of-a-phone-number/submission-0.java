class Solution {
    public List<String> explore(List<Character>[] phone, String str, String digits, int idx) {
        List<String> res = new ArrayList();

        if (idx == digits.length()) {
            res.add(str);
            return res;
        }

        int digit = digits.charAt(idx) - '0';
        for (char d : phone[digit - 2]) {
            res.addAll(explore(phone, str + d, digits, idx + 1));
        }

        return res;
    }

    public List<String> letterCombinations(String digits) {
        List<Character>[] phone = new ArrayList[9];
        phone[0] = new ArrayList<>(Arrays.asList('a','b','c'));
        phone[1] = new ArrayList<>(Arrays.asList('d','e','f'));
        phone[2] = new ArrayList<>(Arrays.asList('g','h','i'));
        phone[3] = new ArrayList<>(Arrays.asList('j','k','l'));
        phone[4] = new ArrayList<>(Arrays.asList('m','n','o'));
        phone[5] = new ArrayList<>(Arrays.asList('p','q','r','s'));
        phone[6] = new ArrayList<>(Arrays.asList('t','u','v'));
        phone[7] = new ArrayList<>(Arrays.asList('w','x','y','z'));

        if (digits.equals("")) {
            return new ArrayList();
        }

        return explore(phone, "", digits, 0);
    }
}
