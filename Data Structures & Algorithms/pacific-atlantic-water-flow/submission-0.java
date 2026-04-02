class Solution {
    public void explore(int[][] heights, int i, int j, int prev, Set<Pair<Integer, Integer>> set) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) {
            return;
        }

        Pair<Integer, Integer> pair = new Pair(i, j);
        if (set.contains(pair)) {
            return;
        }

        if (heights[i][j] < prev) {
            return;
        }

        set.add(pair);
        explore(heights, i - 1, j, heights[i][j], set);
        explore(heights, i, j - 1, heights[i][j], set);
        explore(heights, i + 1, j, heights[i][j], set);
        explore(heights, i, j + 1, heights[i][j], set);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Pair<Integer, Integer>> pacific = new HashSet();
        for (int i = 0; i < heights.length; i ++) {
            explore(heights, i, 0, 0, pacific);
        }
        for (int j = 1; j < heights[0].length; j ++) {
            explore(heights, 0, j, 0, pacific);
        }

        Set<Pair<Integer, Integer>> atlantic = new HashSet();
        for (int i = 0; i < heights.length; i ++) {
            explore(heights, i, heights[0].length - 1, 0, atlantic);
        }
        for (int j = 0; j < heights[0].length - 1; j ++) {
            explore(heights, heights.length - 1, j, 0, atlantic);
        }

        List<List<Integer>> res = new ArrayList();
        for (var pair : pacific) {
            if (atlantic.contains(pair)) {
                res.add(new ArrayList(Arrays.asList(pair.getKey(), pair.getValue())));
            }
        }

        return res;
    }
}
