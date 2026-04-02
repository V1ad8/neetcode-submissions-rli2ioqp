class Solution {
    public void dfs(String node, HashMap<String, List<String>> map, List<String> res) {
        List<String> list = map.get(node);
        while (list != null && !list.isEmpty()) {
            String next = list.remove(0);
            dfs(next, map, res);
        }
        res.add(0, node);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> map = new HashMap();

        for (List<String> ticket : tickets) {
            map.compute(ticket.get(0), (k, v) -> {
                if (v == null) {
                    return new ArrayList(Arrays.asList(ticket.get(1)));
                } else {
                    v.add(ticket.get(1));
                    return v;
                }
            });
        }

        for (var e : map.entrySet()) {
            Collections.sort(e.getValue());
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        List<String> res = new ArrayList();
        dfs("JFK", map, res);

        return res;
    }
}
