class Solution {
    public char toLowerCase(char c) {
        if ((c >= 'A') && (c <= 'Z')) {
            return (char)(c - 'A' + 'a');
        } else {
            return c;
        }
    }

    public boolean isAlphanum(char c) {
        return ((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z') || (c >= '0') && (c <= '9'));
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !isAlphanum(s.charAt(left))) left++;
            while (left < right && !isAlphanum(s.charAt(right))) right--;

            if (left >= right) {
                return true;
            }

            if (toLowerCase(s.charAt(left)) != toLowerCase(s.charAt(right))) {
                return false;
            }

            left ++;
            right --;
        }

        return true;
    }
}
