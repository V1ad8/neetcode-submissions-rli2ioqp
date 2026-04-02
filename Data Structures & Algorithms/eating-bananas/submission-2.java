class Solution {
    public boolean canEat(int[] piles, int h, int k) {
        int p = 0;

        int[] cpy = new int[piles.length];
        for (int i = 0; i < piles.length; i ++) {
            cpy[i] = piles[i];
        }

        for (int i = 0; i < piles.length; i ++) {
            if (piles[i] % k != 0) {
                h --;
            }

            h -= piles[i] / k;

            if (h < 0) {
                return false;
            }
        }

        return h >= 0;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = piles[0];

        for (int i = 1; i < piles.length; i ++) {
            max = piles[i] > max ? piles[i] : max;
        }

        int n;
        while (min < max) {
            n = (min + max) / 2;

            if (canEat(piles, h, n)) {
                max = n - 1;
            } else {
                min = n + 1;
            }
        }

        if (canEat(piles, h, min)) {
            return min;
        } else {
            return min + 1;
        }
    }
}
