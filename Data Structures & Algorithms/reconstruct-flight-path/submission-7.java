class Solution {
    public void dfs(String node, HashMap<String, PriorityQueue<String>> map, List<String> res) {
        PriorityQueue<String> pq = map.get(node);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), map, res);
        }
        res.add(0, node);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap();

        for (List<String> ticket : tickets) {
            map.compute(ticket.get(0), (k, v) -> {
                if (v == null) {
                    return new PriorityQueue(Arrays.asList(ticket.get(1)));
                } else {
                    v.add(ticket.get(1));
                    return v;
                }
            });
        }

        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        List<String> res = new ArrayList();
        dfs("JFK", map, res);

        return res;
    }
}
