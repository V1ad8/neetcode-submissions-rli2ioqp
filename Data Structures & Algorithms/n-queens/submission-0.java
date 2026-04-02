class Solution {
    public List<List<Integer>> explore(int n, List<Integer> soFar) {
        List<List<Integer>> res = new ArrayList();

        if (soFar.size() == n) {
            res.add(new ArrayList(soFar));
            return res;
        }

        int idx = soFar.size();
        for (int q = 0; q < n; q ++) {
            boolean canPut = true;
            for (int p = 0; p < idx && canPut; p ++) {
                if (soFar.get(p) == q || (q - soFar.get(p) == idx - p) || (soFar.get(p) - q == idx - p)) {
                    canPut = false;
                }
            }

            if (canPut) {
                soFar.add(q);
                res.addAll(explore(n, soFar));
                soFar.remove(idx);
            }
        }

        return res;

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        List<List<Integer>> ret = explore(n, new ArrayList());
        for (List<Integer> l : ret) {
            List<String> list = new ArrayList();
            System.out.println(l);

            for (var val : l) {
                String s = "";

                for (int i = 0; i < val; i ++) {
                    s += ".";
                }

                s += "Q";

                for (int i = val + 1; i < n; i ++) {
                    s += ".";
                }

                list.add(s);
            }

            res.add(list);
        }

        return res;
    }
}
